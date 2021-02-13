package mobilePhone;

public class SilentState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone) {
    phone.lightUpScreen();
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.lightUpScreen();
  }

  @Override public void onVolumeButtonUp(Phone phone) {
    phone.turnVolumeUp();
    phone.setState(new SoundState());
  }

  @Override public void onVolumeButtonDown(Phone phone) {
    System.out.println("The volume is already at its lowest :(");
  }
}

