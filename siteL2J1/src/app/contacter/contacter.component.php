<?php
    $nom = $_POST['nom'];
    $mail_joueur = $_POST['email'];
    $message = $_POST['message'];

    $email_envoyeur = 'taru94@hotmail.fr';
    $email_sujet = "Un message venant d'un joueur"
    $email_contenu = "Nom du joueur : $nom \n",
                      "Mail du joueur : $mail_joueur \n",
                      "Message du joueur : $message";

    $message_envoye_a = "tarujan.vallipuram@gmail.com"

    $header = "De : $email_envoyeur \r\n ";

    $header = "Répondre à : $mail_joueur \r\n ";

    mail($message_envoye_a, $email_sujet, $email_contenu, $header);
    header("Location : contacter.component.html");
 ?>
