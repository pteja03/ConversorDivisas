package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import models.Consulta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Bienvenido a DiviHeiss");
        System.out.println("1 Convertir Divisas"+"\n"+
                "0 Salir"+"\n"+"Ingresa la opcion deseada:");
        Scanner opciones = new Scanner(System.in);
        var opcion = opciones.nextInt();
        while (opcion != 0){
            switch (opcion) {



                    case 1: {

                        try {
                            Scanner lectura = new Scanner(System.in);
                            System.out.println("Ingresa el codigo de divisa para convertir:");

                            var de = lectura.nextLine();


                            Scanner lectura1 = new Scanner(System.in);
                            System.out.println("Ahora ingresa el codigo de divisa a convertir:");
                            var a = lectura1.nextLine();

                            Scanner lectura2 = new Scanner(System.in);
                            System.out.println("Que cantidad seria?:");

                            var cantidad = lectura2.nextInt();

                            String url = "https://v6.exchangerate-api.com/v6/c99cecfe6f9267ba8c40f003/pair/" + de + "/" + a + "/" + cantidad;

                            HttpClient client = HttpClient.newHttpClient();
                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(url))
                                    .build();
                            HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());

                            String json = response.body();
                            System.out.println(json);
                            Gson gson = new Gson();
                            Consulta miConsulta = gson.fromJson(json, Consulta.class);


                            System.out.println("Convertiremos la cantidad de: " + miConsulta.getCantidad() + " "
                                    + miConsulta.getDe() + ", " + "en "
                                    + miConsulta.getA() +
                                    ". " + "Igual: " + miConsulta.getResultado() + " " +
                                    miConsulta.getA() + ". " + "Con fecha de: " + " " + miConsulta.getFecha().substring(0, 16) + " UTC");


                        } catch (IllegalStateException e) {
                            System.out.println("NO ENCONTRE EL CODIGO DE DIVISA VERIFICALO PORFAVOR");
                            System.out.println(e.getMessage());
                        } catch (NullPointerException e) {
                            System.out.println("NO ENCONTRE EL CODIGO DE DIVISA VERIFICALO PORFAVOR");
                        } catch (InputMismatchException e) {
                            System.out.println("La cantidad debe ser introducida en caracteres numericos");
                            System.out.println(e.getMessage());
                        } catch (JsonSyntaxException e) {
                            System.out.println("NO ENCONTRE EL CODIGO DE DIVISA VERIFICALO PORFAVOR");
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                default: {
                    System.out.println("opcion incorrecta");
                    break;
                }







            }break;




            }
        }

    }

