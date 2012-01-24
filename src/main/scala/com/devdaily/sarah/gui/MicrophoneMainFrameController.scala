package com.devdaily.sarah.gui

import com.devdaily.sarah.Sarah
import java.awt.BorderLayout
import javax.swing.SwingUtilities
import java.awt.Color
import javax.swing.JPanel
import javax.swing.ImageIcon
import javax.swing.JLabel
import java.awt.FlowLayout
import com.devdaily.sarah.plugins.Utils
import com.devdaily.sarah.actors.Brain

class MicrophoneMainFrameController(sarah: Sarah) extends BaseMainFrameController {

  // constructor
  val headerPanel = new MicrophoneMainFrameHeaderPanel
  val microphonePanel = new MicrophonePanel
  val mainFrame = new MicrophoneMainFrame
  mainFrame.add(headerPanel, BorderLayout.NORTH)
  mainFrame.add(microphonePanel, BorderLayout.CENTER)
  updateUISarahIsListening
  
  def getMainFrame = mainFrame

  def updateUISarahIsSleepingButHeardSomething {
    invokeLater(microphonePanel.setSarahIsSleepingButHeardSomething)
    invokeLater(headerPanel.setSarahIsSleepingButHeardSomething)
    // want a little pause here, otherwise this is just a flicker
    Utils.sleep(Brain.SLEEP_500_MS)
  } 
  def updateUISarahIsSleeping {
    invokeLater(microphonePanel.setSarahIsSleeping)
    invokeLater(headerPanel.setSarahIsSleeping)
  } 
  def updateUISarahIsSpeaking { 
    invokeLater(microphonePanel.setSarahIsSpeaking)
    invokeLater(headerPanel.setSarahIsSpeaking)
  }
  def updateUISarahIsListening { 
    invokeLater(microphonePanel.setSarahIsListening)
    invokeLater(headerPanel.setSarahIsSpeaking)
  }
  def updateUISarahIsNotListening { 
    invokeLater(microphonePanel.setSarahIsNotListening)
    invokeLater(headerPanel.setSarahIsSpeaking)
  }

}

/**
 * HEADER
 */
class MicrophoneMainFrameHeaderPanel extends JPanel {

  val sarahImage = new ImageIcon(classOf[com.devdaily.sarah.Sarah].getResource("sarah-header-image.png"))
  val imageLabel = new JLabel(sarahImage)
  val flowLayout = new FlowLayout
  flowLayout.setAlignment(FlowLayout.CENTER)
  this.setLayout(flowLayout)
  this.add(imageLabel)

  def setSarahIsSleepingButHeardSomething {
    this.setBackground(MicrophoneMainFrameController.SARAH_IS_SLEEPING_BUT_HEARD_SOMETHING_COLOR)
  }

  def setSarahIsSleeping {
    this.setBackground(MicrophoneMainFrameController.SARAH_IS_SLEEPING_COLOR)
  }

  def setSarahIsSpeaking {
    this.setBackground(MicrophoneMainFrameController.SARAH_IS_SPEAKING_COLOR)
  }

  def setSarahIsListening {
    this.setBackground(MicrophoneMainFrameController.SARAH_IS_LISTENING_COLOR)
  }

  def setSarahIsNotListening {
    this.setBackground(MicrophoneMainFrameController.SARAH_IS_NOT_LISTENING_COLOR)
  }

}

/**
 * CONSTANTS
 */
object MicrophoneMainFrameController {
  
  val SARAH_IS_SLEEPING_BUT_HEARD_SOMETHING_COLOR = Color.LIGHT_GRAY
  val SARAH_IS_SLEEPING_COLOR      = Color.DARK_GRAY
  val SARAH_IS_SPEAKING_COLOR      = new Color(255, 250, 205)  // yellow chiffon
  val SARAH_IS_LISTENING_COLOR     = new Color(170, 194, 156)  // green color
  val SARAH_IS_NOT_LISTENING_COLOR = new Color(128, 128, 128)  // grey

}





