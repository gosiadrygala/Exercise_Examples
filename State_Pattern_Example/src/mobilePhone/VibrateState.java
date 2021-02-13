package mobilePhone;

public class VibrateState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone) {
    phone.lightUpScreen();
    phone.vibrate();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone) {
    phone.lightUpScreen();
    phone.vibrate();
  }

  @Override public void onVolumeButtonUp(Phone phone) {
    phone.turnVolumeUp();
    phone.setState(new SoundState());
  }

  @Override public void onVolumeButtonDown(Phone phone) {
    int vol = phone.getVolume();
    if(vol == 1){
      phone.turnVolumeDown();
      phone.setState(new SilentState());
    }
    else if(vol == 0){
      phone.setState(new SilentState());
    }
    else{
      phone.turnVolumeDown();
    }
  }
}


