package mobilePhone;

public class SoundState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone){
    phone.beepBeep();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone){
    phone.playRingtone();
  }

  @Override public void onVolumeButtonUp(Phone phone) {
    int vol = phone.getVolume();
    if(vol < 100){
      phone.turnVolumeUp();
    }
    else{
      System.out.println("Volume is on max");
    }
  }

  @Override public void onVolumeButtonDown(Phone phone) {
    int vol = phone.getVolume();
    if(vol > 1){
      phone.turnVolumeDown();
    }
    else{
      phone.setState(new SilentState());
    }
  }
}


