package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class QRController {
	
	
	@GetMapping("/qr")
    public void getQRCode(HttpServletResponse response) throws Exception {

        String url = "http://localhost:8080";

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(
                url,
                BarcodeFormat.QR_CODE,
                300,
                300
        );

        response.setContentType("image/png");

        MatrixToImageWriter.writeToStream(
                bitMatrix,
                "PNG",
                response.getOutputStream()
        );
    }

}
