/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midibox;

/**
 *
 * @author soji_2
 * 
 * JDOオブジェクト用
 * 削除するときに専用の処理(discard)が必要
 */
public interface IDiscardNeeded {
    void discard();
}
