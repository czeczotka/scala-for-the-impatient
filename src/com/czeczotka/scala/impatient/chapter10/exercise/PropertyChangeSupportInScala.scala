package com.czeczotka.scala.impatient.chapter10.exercise

import java.beans.PropertyChangeListener

trait PropertyChangeSupportInScala {

  private[this] val pcs = new java.beans.PropertyChangeSupport()

  def addPropertyChangeListener(listener: PropertyChangeListener) {
    pcs.addPropertyChangeListener(listener)
  }

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) {
    pcs.addPropertyChangeListener(propertyName, listener)
  }

  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) {
    pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
  }

//    void 	fireIndexedPropertyChange(String propertyName, int index, int oldValue, int newValue)
//    void 	fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue)
//    void 	firePropertyChange(PropertyChangeEvent event)
//    void 	firePropertyChange(String propertyName, boolean oldValue, boolean newValue)
//    void 	firePropertyChange(String propertyName, int oldValue, int newValue)
//    void 	firePropertyChange(String propertyName, Object oldValue, Object newValue)
//    PropertyChangeListener[] 	getPropertyChangeListeners()
//    PropertyChangeListener[] 	getPropertyChangeListeners(String propertyName)
//    boolean 	hasListeners(String propertyName)
//    void 	removePropertyChangeListener(PropertyChangeListener listener)
//    void 	removePropertyChangeListener(String propertyName, PropertyChangeListener listener)

}