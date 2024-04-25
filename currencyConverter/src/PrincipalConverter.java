import com.google.gson.Gson;
import model.ConversionResponse;
import model.CurrencyResponse;
import operations.Operations;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConverter {
    public static void main(String[] args) throws IOException, InterruptedException {

        String clave = "70d2082d585685dd726dc5e8";
        String direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        CurrencyResponse cr = new Gson().fromJson(json, CurrencyResponse.class);

        Operations operation = new Operations(cr);

        while (true) {
            Scanner lectura = new Scanner(System.in);
            System.out.println("Hola, las opciones de conversion son las siguientes: \n 1 - USD: \n 2 - AED: \n 3 - COP: \n Por favor ingrese el numero relacionado con la " +
                    "moneda a la cual quiere convertir");

            int currencyType = 0;

            while (true) {
                currencyType = lectura.nextInt();
                if (currencyType >= 1 && currencyType <= 3)
                    break;
                System.out.println("Por favor ingrese un valor valido para seleccionar la moneda");
            }


            System.out.println("Por favor ingrese el valor a convertir");
            String value = lectura.next();

            value = value.replace(',', '.');
            double newValue = Double.parseDouble(value);

            System.out.println("El resultado de la conversion es: \n" + operation.convertValue(newValue, currencyType));


            System.out.println("Quiere realizar otra conversion?. Por favor digite 2 para NO, de lo contrario oprima cualquier tecla");
            String reiniciar = lectura.next();

            if (reiniciar.equals("2")) {
                System.out.println("Quiere ver el historial de conversiones?. Por favor digite 1 para SI o digite cualquier otra tecla para finalizar");
                String history = lectura.next();

                if (history.equals("1")) {
                    System.out.println("Historial de operaciones: \n");
                    operation.getExchangeHistorialList().forEach(h -> {
                        System.out.println("Modena: " + h.getCurrencyType() + " Valor a convertir: " + h.getValue() + " Resultado: " + h.getResult());
                    });
                }
                break;
            }
        }
    }
}