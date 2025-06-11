package controllers;

import comunidad.Comunidad;
import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorPost;
import convertores.ConvertorUsuario;
import edu.udelp.foros2.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import posts.PostDTO;
import usuarios.Usuario;
import usuarios.UsuarioDTO;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static controllers.LoginRegistroController.usuarioDTOActual;
import static convertores.ConvertorPost.listPostDTO;
import static convertores.ConvertorComunidad.listComunidadDTO;
import static convertores.ConvertorUsuario.listUsuarioDTO;

public class comunidadController {
    public int postId;
    @FXML
    private Label lblNombreCom;
    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblSeguidores;

    @FXML
    private ImageView logoComun;

    @FXML
    private VBox lugarPostComunidad;

    int num;

    int comunidadId=comunidadesController.comunId;
    ArrayList<ComunidadDTO> comunidadDTO = ConvertorComunidad.jsonTextoComunidad();




    @FXML
    public void initialize() {
        lugarPostComunidad.getChildren().clear();

        ArrayList<PostDTO> postsDTO = ConvertorPost.jsonTextoPost();
        int cantidad = postsDTO.size();
        lblNombreCom.setText(comunidadDTO.get(comunidadId).getNombre());
        lblDescripcion.setText(comunidadDTO.get(comunidadId).getDescripcion());
        num=comunidadDTO.get(comunidadId).numPersonas;

        lblSeguidores.setText("Seguidores: "+num);

        Image imagenLogo = null;


        if (null != comunidadDTO.get(comunidadId).getLogo()) {

            File file = new File(comunidadDTO.get(comunidadId).getLogo());
            //imagenLogo = new Image(file.toURI().toString());
            if (file.exists()) {
                imagenLogo = new Image(file.toURI().toString());
                logoComun.setImage(imagenLogo);
            }
            logoComun.setImage(imagenLogo);
        }
        for (int i = 0; i < cantidad; i++){
                if(Objects.equals(comunidadDTO.get(comunidadId).getNombre(), postsDTO.get(i).getComunidadDTO().getNombre())) {
                    boolean imagenExiste = false;
                    boolean archivoExiste = false;


                    TextFlow textoFlowPost = new TextFlow();
                    TextFlow textoFlowRepost = new TextFlow();

                    Text usuario = new Text("Usuario: " + postsDTO.get(i).getUsuarioDTO().getUsuario() + "\n");
                    Text descripcion = new Text("Post: " + postsDTO.get(i).getDescripcion() + "\n");
                    Text fecha = new Text("Fecha de creacion: " + postsDTO.get(i).getFecha() + "\n");

                    if (null == postsDTO.get(i).getOriginalPost()) {
                        textoFlowPost.getChildren().addAll(usuario, descripcion, fecha);
                    }


                    ImageView imagen = null;
                    Hyperlink enlace = null;

                    if (null != postsDTO.get(i).getImagen()) {
                        imagenExiste = true;
                        File file = new File(postsDTO.get(i).getImagen());
                        imagen = new ImageView(new Image(file.toURI().toString()));
                        imagen.setPreserveRatio(true);
                    }


                    if (null != postsDTO.get(i).getArchivo()) {
                        archivoExiste = true;
                        File archivo = new File(postsDTO.get(i).getArchivo());
                        enlace = new Hyperlink(postsDTO.get(i).getArchivo());
                        enlace.setOnAction(event -> {
                            if (archivo.exists()) {
                                try {
                                    Desktop.getDesktop().open(archivo);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    Button btnSeguirUsuario = new Button("Seguir Usuario");
                    int segur=i;
                    btnSeguirUsuario.setOnAction(event -> {
                        listPostDTO=postsDTO;
                        listUsuarioDTO= ConvertorUsuario.jsonTextoUsuario();
                        ArrayList<String> hey=new ArrayList<>();
                        hey.add(listPostDTO.get(segur).getUsuarioDTO().getUsuario());


                        for (int j=0;j<listUsuarioDTO.size();j++) {
                            if(Objects.equals(usuarioDTOActual.getUsuario(), listUsuarioDTO.get(j).getUsuario())){
                                listUsuarioDTO.get(j).getFollowers().add(hey.get(0));
                                ConvertorUsuario.textoJsonUsuarioModificacion();


                                listUsuarioDTO.clear();
                                listPostDTO.clear();
                                postsDTO.clear();
                                ConvertorPost.getListPostDTO().clear();
                                ConvertorUsuario.getListUsuarioDTO().clear();

                                listUsuarioDTO=ConvertorUsuario.jsonTextoUsuario();

                                break;
                            }
                        }




                        Platform.runLater(() -> {
                            lugarPostComunidad.getChildren().clear();
                            initialize();
                        });
                    });

                    javafx.scene.control.Button btnRepostear = new javafx.scene.control.Button("Repostear");

                    int finalI = i;
                    btnRepostear.setOnAction(event -> {


                        //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post

                        String fechaRepStr = LocalDate.now().toString();

                        boolean nsfw = postsDTO.get(finalI).isNsfw();

                        boolean plus18 = postsDTO.get(finalI).isPlus18();

                        listPostDTO.add(new PostDTO(cantidad,comunidadDTO.get(comunidadId), usuarioDTOActual, null, null, null, fechaRepStr, nsfw, plus18, postsDTO.get(finalI),postsDTO.get(finalI).getTags()));

                        ConvertorPost.textoJsonPost();

                        Platform.runLater(() -> {
                            lugarPostComunidad.getChildren().clear();
                            initialize();
                        });


                    });

                    if (null != postsDTO.get(i).getOriginalPost()) {
                        Text usuarioRep = new Text("Usuario: " + postsDTO.get(i).getUsuarioDTO().getUsuario() + "\n");
                        Text usuarioOri = new Text("Usuario Original: " + postsDTO.get(i).getOriginalPost().getUsuarioDTO().getUsuario() + "\n");
                        Text descripcionOri = new Text("Post Original: " + postsDTO.get(i).getOriginalPost().getDescripcion() + "\n");
                        Text fechaOri = new Text("Fecha de creacion Original: " + postsDTO.get(i).getOriginalPost().getFecha() + "\n");
                        Text fechaRep = new Text("Fecha de reposteo: " + postsDTO.get(i).getFecha() + "\n");
                        textoFlowRepost.getChildren().addAll(usuarioRep, usuarioOri, descripcionOri, fechaOri, fechaRep);

                        if (null != postsDTO.get(i).getOriginalPost().getImagen()) {
                            imagenExiste = true;
                            File file = new File(postsDTO.get(i).getOriginalPost().getImagen());
                            imagen = new ImageView(new Image(file.toURI().toString()));
                            imagen.setPreserveRatio(true);
                        }


                        if (null != postsDTO.get(i).getOriginalPost().getArchivo()) {
                            archivoExiste = true;
                            File archivo = new File(postsDTO.get(i).getOriginalPost().getArchivo());
                            enlace = new Hyperlink(postsDTO.get(i).getOriginalPost().getArchivo());
                            enlace.setOnAction(event -> {
                                if (archivo.exists()) {
                                    try {
                                        Desktop.getDesktop().open(archivo);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }


                    }


                    javafx.scene.control.Button btnComentarios = new javafx.scene.control.Button("Comentarios");
                    int comenI=i;
                    btnComentarios.setOnAction(event -> {
                        postId = comenI;
                        try {

                            App.setRoot("comentarios");

                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                    });


                    HBox hboxBotones = new HBox();

                    javafx.scene.control.Button btnBuena = new javafx.scene.control.Button("Buena Calificacion");
                    javafx.scene.control.Button btnMala = new Button("Mala Calificacion");

                    Text textoBuenas = new Text();
                    Text textoMalas = new Text();

                    Long calificacionesBuenas = postsDTO.get(finalI).getCalificacionesBuenas();
                    Long calificacionesMalas = postsDTO.get(finalI).getCalificacionesMalas();

                    textoBuenas.setText("Buenas: " + (calificacionesBuenas != null ? calificacionesBuenas : 0));
                    textoMalas.setText("Malas: " + (calificacionesMalas != null ? calificacionesMalas : 0));

                    btnBuena.setOnAction(event -> {
                        long buenas = (postsDTO.get(finalI).getCalificacionesBuenas() != null ? postsDTO.get(finalI).getCalificacionesBuenas() : 0) + 1;

                        postsDTO.get(finalI).setCalificacionesBuenas(buenas);

                        textoBuenas.setText("Buenas: " + buenas);

                        ConvertorPost.textoJsonPost();

                    });

                    btnMala.setOnAction(event -> {
                        Long malas = (postsDTO.get(finalI).getCalificacionesMalas() != null ? postsDTO.get(finalI).getCalificacionesMalas() : 0) + 1;

                        postsDTO.get(finalI).setCalificacionesMalas(malas);

                        textoMalas.setText("Malas: " + malas);
                        ConvertorPost.textoJsonPost();


                    });
                    hboxBotones.getChildren().addAll(btnBuena, textoBuenas, btnMala, textoMalas);


                    if (imagenExiste && archivoExiste) {

                        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
                            lugarPostComunidad.getChildren().addAll(textoFlowRepost,btnSeguirUsuario,btnComentarios, imagen, enlace, hboxBotones);

                        } else {
                            lugarPostComunidad.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, imagen, enlace, hboxBotones);

                        }

                    } else if (imagenExiste && !archivoExiste) {
                        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
                            lugarPostComunidad.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, imagen, hboxBotones);

                        } else {
                            lugarPostComunidad.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, imagen, hboxBotones);

                        }


                    } else if (!imagenExiste && archivoExiste) {
                        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
                            lugarPostComunidad.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, enlace, hboxBotones);

                        } else {
                            lugarPostComunidad.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, enlace, hboxBotones);

                        }

                    } else {
                        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
                            lugarPostComunidad.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, hboxBotones);

                        } else {
                            lugarPostComunidad.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, hboxBotones);

                        }

                    }
                }





        }


    }

    public int getComunidadId() {
        return comunidadId;
    }
    /*
    public Usuario conversorStringUsuarioComunidad(){
        UsuarioDTO usuarioDTO=comunidadDTO.get(comunidadId).getUsuarioDTO();
        Usuario usuario=new Usuario(usuarioDTO.getNombre(),usuarioDTO.getPassword(),usuarioDTO.getDescription(),usuarioDTO.getGenero(),usuarioDTO.getEmail(),
                usuarioDTO.getFechaNacimiento(),usuarioDTO.getUsuario(),usuarioDTO.getStatus());
        return usuario;
    }
    public Comunidad conversorStringComunidad(){
        Comunidad comunidad=new Comunidad(comunidadId,comunidadDTO.get(comunidadId).getNombre(),conversorStringUsuarioComunidad(),comunidadDTO.get(comunidadId).getDescripcion(),comunidadDTO.get(comunidadId).getFecha(),comunidadDTO.get(comunidadId).getLogo(),comunidadDTO.get(comunidadId).isNsfw(),comunidadDTO.get(comunidadId).isPlus18());
        return comunidad;
    }
*/
    @FXML
    public void onBack(ActionEvent event) {

        try {
            App.setRoot("comunidades");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void onCrearPost(ActionEvent event) {

        try {
            App.setRoot("crearNuevoPost");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void onSeguir(ActionEvent event) {

        listComunidadDTO=comunidadDTO;

        num=listComunidadDTO.get(comunidadId).numPersonas;
        num++;

        ArrayList<String> hey=new ArrayList<>();
        hey.add(usuarioDTOActual.getUsuario());
        listComunidadDTO.get(comunidadId).getSeguidores().add(hey.get(0));
        listComunidadDTO.get(comunidadId).setNumPersonas(num);
        ConvertorComunidad.textoJsonComunidadModificacion();

        listComunidadDTO.clear();
        comunidadDTO.clear();
        ConvertorComunidad.getListComunidadDTO().clear();
        Platform.runLater(() -> {
            lugarPostComunidad.getChildren().clear();
            initialize();
        });

    }

}
