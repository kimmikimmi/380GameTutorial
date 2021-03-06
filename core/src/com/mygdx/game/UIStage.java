package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.data.CompositeItemVO;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;
import com.uwsoft.editor.renderer.resources.IResourceRetriever;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;
import com.badlogic.gdx.scenes.scene2d.*;



import java.awt.event.InputEvent;


/**
 * Created by Jaden on 18/10/2015.
 */
public class UIStage extends Stage {

    public UIStage(IResourceRetriever ir) {
        //make button work.
        Gdx.input.setInputProcessor(this);

        ProjectInfoVO projectInfo = ir.getProjectVO();

        CompositeItemVO menuButtonData = projectInfo.libraryItems.get("menuButton");
        CompositeActor buttonActor = new CompositeActor(menuButtonData, ir);


        addActor(buttonActor);

        buttonActor.setX((getWidth() - buttonActor.getWidth()));
        buttonActor.setY((getHeight() - buttonActor.getHeight()));

//        buttonActor.addListener(new ClickListener() {
//            public void clicked (InputEvent event, float x, float y) {
//                System.out.println("a");
//            }
//        });
    }





}
