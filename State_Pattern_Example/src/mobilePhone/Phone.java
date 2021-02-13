package mobilePhone;

public class Phone {
  private PhoneState currentState = new SilentState();
  private int currentVolume;

  public void receiveMessage(String txt){
    currentState.onReceiveMessage(txt, this);
  }

  public void receiveCall(){
    currentState.onReceiveCall(this);
  }

  public void volumeButtonUp(){
    currentState.onVolumeButtonUp(this);
  }

  public void volumeButtonDown(){
    currentState.onVolumeButtonDown(this);
  }

  void goToSilent(){
    currentState = new SilentState();
  }

  void goToVibrate(){
    currentState = new VibrateState();
  }

  void goToSound(){
    currentState = new SoundState();
  }

  void turnVolumeUp(){
    currentVolume++;
  }

  void turnVolumeDown(){ currentVolume--; }

  void playRingtone(){
    System.out.println("Ding ding ding!!");
  }

  void vibrate(){
    System.out.println("*wibrating sound*");
  }

  void lightUpScreen(){
    System.out.println("*the screen lighted up*");
  }

  void beepBeep(){
    System.out.println("Beep beep!");
  }

  int getVolume(){
    return currentVolume;
  }

  void setState(PhoneState state){
    currentState = state;
  }

}
