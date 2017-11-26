import org.apache.commons.cli.*;

public class CommandLineUtils {
    
    /*public CommandLine makeCommandLine(){
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("h", false, "Afficher l'aide");
        options.addOption("i", true, "Spécifier le chemin du CSV d'entrée");
        options.addOption("categorie", true, "Filtre les produits selon la catégorie");
        options.addOption("etiquette", true, "Définit le chemin du pdf qui contiendra les etiquettes");
        options.addOption("fiche", true, "Definit le chemin du pdf qui contiendra les fiches produits");
        options.addOption("tva", true, "Définit le montant de la TVA");
        try {
            CommandLine commandLine = parser.parse(options, args);
            System.out.println(commandLine.getOptionValue("categorie"));
            System.out.println(commandLine.getOptionValue("i"));

            if(commandLine.hasOption("h")){
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp("Paramètres :", options);
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }*/
}
