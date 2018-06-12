package com.pablo.controlcod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.pablo.controlcod.Empaquetado"
)
@ActionRegistration(
        iconBase = "com/pablo/controlcod/paque.png",
        displayName = "#CTL_Empaquetado"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0)
    ,
  @ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_Empaquetado=Empaquetado")
public final class Empaquetado implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            //Pedimos el nombre para el .jar
            String jar = JOptionPane.showInputDialog("Nome de tu jar: ", e);
            //Pedimos en nombre del main
            String mainclass = JOptionPane.showInputDialog("Nombre de tu Main Class: ");
            //Pedimos un nombre
            String nombre = JOptionPane.showInputDialog("Nombre: ");
            //Pedimos el nombre de la app
            String nombreapp = JOptionPane.showInputDialog("Nombre de la App ");
            //Montamos el comando
            String[] cmd = {"javapackager ", "-deploy ", "-native ", "-outdir ", "sample ", "srcfiles ", jar, "-appclass ", mainclass, "-name ", nombre, "-title ", nombreapp};
            //lo lanzamos en la terminal
            Process process = Runtime.getRuntime().exec(cmd);
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            JOptionPane.showMessageDialog(null, "SUU");
        } catch (Exception ea) {
            System.out.println("Error");
        }
    }
}
