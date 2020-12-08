package com.andoriyu.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ContactoActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText email;
    private EditText mensaje;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = (EditText) findViewById(R.id.titNombre);
        email = (EditText) findViewById(R.id.titEmail);
        mensaje = (EditText) findViewById(R.id.titMensajeEmail);
        enviar = (Button) findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
                Toast.makeText(ContactoActivity.this, getString(R.string.mensajeenviado), Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    private void sendEmail() {

        final String correo = "ing.andresmojica@gmail.com";
        final String contraseña = "120708am";
        Session session;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        try {
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo, contraseña);
                }
            });

            if (session!=null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("@string/subject_correo");
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email.toString()));
                message.setContent(mensaje.getText().toString(),"text,html; charset=utf-8");
                Transport.send(message);



            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}