package controllers;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import posts.PostDTO;

import static controllers.LoginRegistroController.usuarioDTOActual;
import static edu.udelp.foros2.Convertor.listPostDTO;

public class foroController {
    static String rutaArchivoPosts="archivoPosts";
    PostDTO originalPostDTO;

    @FXML
    private VBox lugarPosts;

    @FXML
    public void initialize() {
        lugarPosts.getChildren().clear();
        int cantidad= Convertor.jsonTextoPost().size();
        boolean botonRepost=false;
        boolean botonRespon=false;

        System.out.println(cantidad);
        for (int i = 0; i < cantidad; i++) {


            boolean imagenExiste = false;
            boolean archivoExiste = false;


            TextFlow textoFlowPost = new TextFlow();
            TextFlow textoFlowRepost = new TextFlow();
            TextFlow textoFlowResponder = new TextFlow();
            Text usuario = new Text("Usuario: " + Convertor.jsonTextoPost().get(i).getUsuarioDTO().getUsuario() + "\n");
            Text descripcion = new Text("Post: " + Convertor.jsonTextoPost().get(i).getDescripcion() + "\n");
            Text fecha = new Text("Fecha de creacion: " + Convertor.jsonTextoPost().get(i).getFecha() + "\n");

            if (null == Convertor.jsonTextoPost().get(i).getOriginalPost()) {
                textoFlowPost.getChildren().addAll(usuario, descripcion, fecha);
                System.out.println(1);
            }


            ImageView imagen = null;
            Hyperlink enlace = null;

            if (null != Convertor.jsonTextoPost().get(i).getImagen()) {
                imagenExiste = true;
                File file = new File(Convertor.jsonTextoPost().get(i).getImagen());
                imagen = new ImageView(new Image(file.toURI().toString()));
                imagen.setPreserveRatio(true);
            }


            if (null != Convertor.jsonTextoPost().get(i).getArchivo()) {
                archivoExiste = true;
                File archivo = new File(Convertor.jsonTextoPost().get(i).getArchivo());
                enlace = new Hyperlink(Convertor.jsonTextoPost().get(i).getArchivo());
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


            Button btnRepostear = new Button("Repostear");

            int finalI = i;
            btnRepostear.setOnAction(event -> {



                //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post

                String fechaRepStr = LocalDate.now().toString();

                boolean nsfw = Convertor.jsonTextoPost().get(finalI).isNsfw();

                boolean plus18 = Convertor.jsonTextoPost().get(finalI).isPlus18();

                listPostDTO.add(new PostDTO(cantidad, usuarioDTOActual, null, null, null, fechaRepStr, nsfw, plus18, Convertor.jsonTextoPost().get(finalI)));

                Convertor.textoJsonPost();

                Platform.runLater(() -> {
                    lugarPosts.getChildren().clear();
                    initialize();
                });


            });

            if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()) {
                Text usuarioRep = new Text("Usuario: " + Convertor.jsonTextoPost().get(i).getUsuarioDTO().getUsuario() + "\n");
                Text usuarioOri = new Text("Usuario Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getUsuarioDTO().getUsuario() + "\n");
                Text descripcionOri = new Text("Post Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getDescripcion() + "\n");
                Text fechaOri = new Text("Fecha de creacion Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getFecha() + "\n");
                Text fechaRep = new Text("Fecha de reposteo: " + Convertor.jsonTextoPost().get(i).getFecha() + "\n");
                textoFlowRepost.getChildren().addAll(usuarioRep, usuarioOri, descripcionOri, fechaOri, fechaRep);
                System.out.println(2);
                if (null != Convertor.jsonTextoPost().get(i).getOriginalPost().getImagen()) {
                    imagenExiste = true;
                    File file = new File(Convertor.jsonTextoPost().get(i).getOriginalPost().getImagen());
                    imagen = new ImageView(new Image(file.toURI().toString()));
                    imagen.setPreserveRatio(true);
                }


                if (null != Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo()) {
                    archivoExiste = true;
                    File archivo = new File(Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo());
                    enlace = new Hyperlink(Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo());
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

            Button btnResponder = new Button("Responder");



            int finalIResponder = i;
            btnResponder.setOnAction(event -> {



                //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post

                String fechaRepStr = LocalDate.now().toString();

                boolean nsfw = Convertor.jsonTextoPost().get(finalIResponder).isNsfw();

                boolean plus18 = Convertor.jsonTextoPost().get(finalIResponder).isPlus18();


                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Responder al post");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(respuestaTexto -> {


                    listPostDTO.add(new PostDTO(cantidad, usuarioDTOActual, respuestaTexto, null, null, fechaRepStr, nsfw, plus18, Convertor.jsonTextoPost().get(finalIResponder)));

                    Convertor.textoJsonPost();



                    Platform.runLater(() -> {
                        lugarPosts.getChildren().clear();
                        initialize();
                    });


                });
            });

                if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()) {
                    Text usuarioRep = new Text("Usuario: " + Convertor.jsonTextoPost().get(i).getUsuarioDTO().getUsuario() + "\n");
                    Text usuarioOri = new Text("Usuario Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getUsuarioDTO().getUsuario() + "\n");
                    Text descripcionRep = new Text("Post Respuesta: " + Convertor.jsonTextoPost().get(i).getDescripcion() + "\n");
                    Text descripcionOri = new Text("Post Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getDescripcion() + "\n");
                    Text fechaOri = new Text("Fecha de creacion Original: " + Convertor.jsonTextoPost().get(i).getOriginalPost().getFecha() + "\n");
                    Text fechaRep = new Text("Fecha de reposteo: " + Convertor.jsonTextoPost().get(i).getFecha() + "\n");
                    textoFlowResponder.getChildren().addAll(usuarioRep, usuarioOri, descripcionOri, descripcionRep, fechaOri, fechaRep);
                    System.out.println(3);
                    if (null != Convertor.jsonTextoPost().get(i).getOriginalPost().getImagen()) {
                        imagenExiste = true;
                        File file = new File(Convertor.jsonTextoPost().get(i).getOriginalPost().getImagen());
                        imagen = new ImageView(new Image(file.toURI().toString()));
                        imagen.setPreserveRatio(true);
                    }


                    if (null != Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo()) {
                        archivoExiste = true;
                        File archivo = new File(Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo());
                        enlace = new Hyperlink(Convertor.jsonTextoPost().get(i).getOriginalPost().getArchivo());
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


                HBox hboxBotones = new HBox();

                Button btnBuena = new Button("Buena Calificacion");
                Button btnMala = new Button("Mala Calificacion");

                Text textoBuenas = new Text();
                Text textoMalas = new Text();

                Long calificacionesBuenas = Convertor.jsonTextoPost().get(finalI).getCalificacionesBuenas();
                Long calificacionesMalas = Convertor.jsonTextoPost().get(finalI).getCalificacionesMalas();

                textoBuenas.setText("Buenas: " + (calificacionesBuenas != null ? calificacionesBuenas : 0));
                textoMalas.setText("Malas: " + (calificacionesMalas != null ? calificacionesMalas : 0));

                btnBuena.setOnAction(event -> {
                    long buenas = (Convertor.jsonTextoPost().get(finalI).getCalificacionesBuenas() != null ? Convertor.jsonTextoPost().get(finalI).getCalificacionesBuenas() : 0) + 1;

                    Convertor.jsonTextoPost().get(finalI).setCalificacionesBuenas(buenas);

                    textoBuenas.setText("Buenas: " + buenas);

                    Convertor.textoJsonPost();

                });


                btnMala.setOnAction(event -> {
                    Long malas = (Convertor.jsonTextoPost().get(finalI).getCalificacionesMalas() != null ? Convertor.jsonTextoPost().get(finalI).getCalificacionesMalas() : 0) + 1;

                    Convertor.jsonTextoPost().get(finalI).setCalificacionesMalas(malas);

                    textoMalas.setText("Malas: " + malas);
                    Convertor.textoJsonPost();


                });
                hboxBotones.getChildren().addAll(btnBuena, textoBuenas, btnMala, textoMalas);


                if (imagenExiste && archivoExiste) {


                    if(null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null==Convertor.jsonTextoPost().get(i).getDescripcion()){
                        lugarPosts.getChildren().addAll(textoFlowRepost, btnRepostear, btnResponder, imagen, enlace, hboxBotones);
                    } else if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null!=Convertor.jsonTextoPost().get(i).getDescripcion()) {
                        lugarPosts.getChildren().addAll(textoFlowResponder, btnRepostear, btnResponder, imagen, enlace, hboxBotones);
                    }else {
                        lugarPosts.getChildren().addAll(textoFlowPost, btnRepostear, btnResponder, imagen, enlace, hboxBotones);
                    }


                } else if (imagenExiste && !archivoExiste) {
                    if(null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null==Convertor.jsonTextoPost().get(i).getDescripcion()){
                        lugarPosts.getChildren().addAll(textoFlowRepost, btnRepostear, btnResponder, imagen, hboxBotones);
                    } else if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null!=Convertor.jsonTextoPost().get(i).getDescripcion()) {
                        lugarPosts.getChildren().addAll(textoFlowResponder, btnRepostear, btnResponder, imagen, hboxBotones);
                    }else {
                        lugarPosts.getChildren().addAll(textoFlowPost, btnRepostear, btnResponder, imagen, hboxBotones);
                    }


                } else if (!imagenExiste && archivoExiste) {
                    if(null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null==Convertor.jsonTextoPost().get(i).getDescripcion()){
                        lugarPosts.getChildren().addAll(textoFlowRepost, btnRepostear, btnResponder, enlace, hboxBotones);
                    } else if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null!=Convertor.jsonTextoPost().get(i).getDescripcion()) {
                        lugarPosts.getChildren().addAll(textoFlowResponder, btnRepostear, btnResponder, enlace, hboxBotones);
                    }else {
                        lugarPosts.getChildren().addAll(textoFlowPost, btnRepostear, btnResponder, enlace, hboxBotones);
                    }


                } else {
                    if(null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null==Convertor.jsonTextoPost().get(i).getDescripcion()){
                        lugarPosts.getChildren().addAll(textoFlowRepost, btnRepostear, btnResponder, hboxBotones);
                    } else if (null != Convertor.jsonTextoPost().get(i).getOriginalPost()&&null!=Convertor.jsonTextoPost().get(i).getDescripcion()) {
                        lugarPosts.getChildren().addAll(textoFlowResponder, btnRepostear, btnResponder, hboxBotones);
                    }else {
                        lugarPosts.getChildren().addAll(textoFlowPost, btnRepostear, btnResponder, hboxBotones);
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
	 
}
