package de.htwg.se.battleship.controller;

import de.htwg.se.battleship.util.observer.IObservable;

/**
 * interface for Controller
 * 
 * @author aullik
 */
public interface IntController extends IObservable {

    /**
     * just an notify to update Observers
     */
    void updateNotify();

    boolean processInputLine(String line);

}
