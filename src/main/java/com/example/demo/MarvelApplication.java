package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarvelApplication {
	
	public static void main(String[] args) throws IOException {
		
		String URL = "http://gateway.marvel.com/v1/public/characters";

		//ajout de premier parametre apikey
		URL = 	URL + "?ts="+ Constantes.TS;
		
		//ajout de deuxieme parametre apikey
		URL = 	URL + "&apikey="+ Constantes.API_PUBLIC_KEY;
				
		//ajout de 3 eme parametre hash (ts + private key + public key)
		URL = 	URL + "&hash="+ Constantes.GENERIC_API_KEY;
		
		URL obj = new URL(URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
	}


}
