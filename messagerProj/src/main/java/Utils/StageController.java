package Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;

/**
* @Author: Jiehang CAO
* @Description:
* @Date: 11:04 2019-03-14
*/
public class StageController {
    /**
     * hash map to store all stages
     */
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();

    /**
     * add stage to hash map
     * @param name
     * @param stage
     */
    public void addStage(String name,Stage stage) {
        stages.put(name,stage);
    }

    /**
     * to get stage in the hash map
     * @param name
     * @return
     */
    public Stage getStage(String name) {
        return stages.get(name);
    }

    /**
     * set primary stage to show
     * @param primaryStageName
     * @param primaryStage
     */
    public void setPrimaryStage(String primaryStageName,Stage primaryStage) {
        this.addStage(primaryStageName,primaryStage);
    }

    /**
     * load stage file, and add it to hash map
     * @param name
     * @param resources
     * @param styles
     * @return
     */
    public boolean loadStage(String name, String resources, StageStyle... styles) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
            Pane tempPane = (Pane)loader.load();

            ControllerStage controllerStage = loader.getController();

            controllerStage.setStageController(this);


            Scene tempScene = new Scene(tempPane);
            Stage tempStage = new Stage();
            tempStage.setScene(tempScene);

            for(StageStyle style: styles) {
                tempStage.initStyle(style);
            }

            this.addStage(name,tempStage);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * set stage to show but don't close current stage
     * @param name
     * @return
     */
    public boolean setStage(String name) {
        this.getStage(name).show();
        return true;
    }

    /**
     * set new stage to show and close current stage
     * @param show
     * @param close
     * @return
     */
    public boolean setStage(String show,String close) {
        getStage(close).close();
        setStage(show);
        return true;
    }

    /**
     * unload stages
     * @param name
     * @return
     */
    public boolean unloadStage(String name) {
        if(stages.remove(name) == null) {
            return false;
        }else {
            return true;
        }
    }

}
