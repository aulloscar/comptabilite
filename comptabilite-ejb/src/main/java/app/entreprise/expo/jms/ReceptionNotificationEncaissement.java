/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entreprise.expo.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Aulloscar
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "NotificationEncaissementFile")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ReceptionNotificationEncaissement implements MessageListener{
    
     public ReceptionNotificationEncaissement() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage om = (ObjectMessage) message;
                int idAffaire = (int) om.getObject();
                System.out.println("Clôture de l'affaire (Affaire " + idAffaire + "): encaissement du second chèque.");
                
                // Enregistrement BD
                
            } else if (message != null) {
                System.out.println("Received non object message");
            } else {
                System.out.println("???");
            }
        } catch(Exception ex){
            System.out.println("Erreur lors de la réception : ");
        }
    }
}
