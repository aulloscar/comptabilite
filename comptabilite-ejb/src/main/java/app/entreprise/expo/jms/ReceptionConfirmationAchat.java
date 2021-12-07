package app.entreprise.expo.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import app.entreprise.menuiserieshared.entities.Affaire;

/**
 *
 * @author Aulloscar
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "ConfirmationAchatTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ReceptionConfirmationAchat implements MessageListener{
    
    public ReceptionConfirmationAchat(){
        
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage om = (ObjectMessage) message;
                int idAffaire = (int) om.getObject();
                System.out.println("Confirmation d'achat reçue dans le service comptabilité (Affaire " + idAffaire + "): encaissement du premier chèque.");
                
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
