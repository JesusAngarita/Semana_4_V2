package com.example.semana_4_v2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MenuItemContacto extends AppCompatActivity {

    public Toolbar toolbar;
    private TextInputEditText etName;
    private TextInputEditText etEmail;
    private TextInputEditText etMensaje;
    private TextInputLayout layout_nombre;
    private TextInputLayout layout_email;
    private TextInputLayout layout_mensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_contacto);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.huella_gato);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        etName = (TextInputEditText) findViewById(R.id.etName);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etMensaje = (TextInputEditText) findViewById(R.id.etMensaje);
        layout_nombre = (TextInputLayout) findViewById(R.id.text_input_layout_nombre);
        layout_email = (TextInputLayout) findViewById(R.id.text_input_layout_email);
        layout_mensaje = (TextInputLayout) findViewById(R.id.text_input_layout_mensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
    }

    public void enviarMail(View v){
        String email = etEmail.getText().toString();
        String mensaje = etMensaje.getText().toString();
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        emailIntent.setAction(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("text/plain");
        startActivity(Intent.createChooser(emailIntent, "Email"));

        // Suponiendo que va a enviar correo electrónico desde localhost
        String host = "localhost";

        // Obtiene propiedades del sistema
        Properties properties = System.getProperties();

        // Configurar servidor de correo
        properties.setProperty("mail.smtp.host", host);

        // Obtener el objeto de sesión predeterminado.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Crea un objeto MimeMessage predeterminado.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(email));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));//prueba enviandose a si mismo

            // Set Subject: header field
            message.setSubject("Asunto del correo!");

            // Send message
            //Transport.send(message);
            System.out.println("Su comentario ha sido enviado!");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private static void toggleTextInputLayoutError(@NonNull TextInputLayout textInputLayout, String msg) {
        textInputLayout.setError(msg);
        if (msg == null) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent anteriorActividad=new Intent(MenuItemContacto.this, MainActivity.class);
            startActivity(anteriorActividad);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
