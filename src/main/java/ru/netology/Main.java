package ru.netology;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Main {
    public static final String URL_NASA_WITH_MY_KEY =
            "https://api.nasa.gov/planetary/apod?api_key=LWbCIQDov9M1d6SABWygR1cBuGu7HLrNFhZPgbMB";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            //1
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();

            HttpGet request = new HttpGet(URL_NASA_WITH_MY_KEY);
            CloseableHttpResponse response = httpClient.execute(request);

            Nasa nasa = mapper.readValue(response.getEntity().getContent(), Nasa.class);
            System.out.println("Полученный от NASA url: " + nasa.getUrl());
            System.out.println("Скачаем картинку и сохраним её в файле в корне проекта.");

            //2
            URL url = new URL(nasa.getUrl());
            BufferedImage image = ImageIO.read(url);

            File output = new File("PerseusFireball_Dandan_960.jpg");
            ImageIO.write(image, "jpg", output);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

