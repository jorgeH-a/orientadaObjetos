package controllers;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import comunidad.Comunidad;
import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorPost;
import convertores.ConvertorUsuario;
import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import posts.PostDTO;

import static controllers.LoginRegistroController.usuarioDTOActual;
import static convertores.ConvertorPost.listPostDTO;
import static convertores.ConvertorUsuario.listUsuarioDTO;


public class foroController {
    static String rutaArchivoPosts="archivoPosts";
    PostDTO originalPostDTO;

    public static int postId;
    @FXML
    private VBox lugarPosts;

    @FXML
    public void initialize() {
        lugarPosts.getChildren().clear();


        ArrayList<PostDTO> postsDTO = ConvertorPost.jsonTextoPost();
        ArrayList<ComunidadDTO> comunidadDTO= ConvertorComunidad.jsonTextoComunidad();
        int cantidad = postsDTO.size();






        boolean botonRepost = false;
        boolean botonRespon = false;

        int ciclo=0;
        for (int i = 0; i < cantidad; i++) {



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
                    lugarPosts.getChildren().clear();
                    initialize();
                });
            });


//Aqui empieza lo del repost
            Button btnRepostear = new Button("Repostear");

            int finalI = i;
            btnRepostear.setOnAction(event -> {


                //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post

                String fechaRepStr = LocalDate.now().toString();

                boolean nsfw = postsDTO.get(finalI).isNsfw();

                boolean plus18 = postsDTO.get(finalI).isPlus18();

                listPostDTO.add(new PostDTO(cantidad,comunidadDTO.get(finalI), usuarioDTOActual, null, null, null, fechaRepStr, nsfw, plus18, postsDTO.get(finalI),postsDTO.get(finalI).getTags()));

                ConvertorPost.textoJsonPost();

                Platform.runLater(() -> {
                    lugarPosts.getChildren().clear();
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
//Aqui termina el repost


//Aqui empieza lo de comentarios
            Button btnComentarios = new Button("Comentarios");
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
//Aqui termina

            HBox hboxBotones = new HBox();

            Button btnBuena = new Button("Buena Calificacion");
            Button btnMala = new Button("Mala Calificacion");

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
            lugarPosts.getChildren().addAll(textoFlowRepost,btnSeguirUsuario,btnComentarios, imagen, enlace, hboxBotones);

        } else {
            lugarPosts.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, imagen, enlace, hboxBotones);

        }

    } else if (imagenExiste && !archivoExiste) {
        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
            lugarPosts.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, imagen, hboxBotones);

        } else {
            lugarPosts.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, imagen, hboxBotones);

        }


    } else if (!imagenExiste && archivoExiste) {
        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
            lugarPosts.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, enlace, hboxBotones);

        } else {
            lugarPosts.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, enlace, hboxBotones);

        }

    } else {
        if (null != postsDTO.get(i).getOriginalPost() && null == postsDTO.get(i).getDescripcion()) {
            lugarPosts.getChildren().addAll(textoFlowRepost,btnSeguirUsuario, btnComentarios, hboxBotones);

        } else {
            lugarPosts.getChildren().addAll(textoFlowPost,btnSeguirUsuario, btnRepostear, btnComentarios, hboxBotones);

        }

    }

        }


    }

    @FXML
    public void onPost(ActionEvent event) {
        try {
            App.setRoot("crearNuevoPost");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @FXML
    public void onComunidad(ActionEvent event) {
        try {
            App.setRoot("comunidades");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @FXML
    public void onSeguirUser(ActionEvent event) {
        try {
            App.setRoot("usuariosSeguidos");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @FXML
    public void onPerfil(ActionEvent event) {
        try {
            App.setRoot("perfil");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @FXML
    private void onBack(ActionEvent event) {
        try {
            App.setRoot("loginRegistro");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	 
}
