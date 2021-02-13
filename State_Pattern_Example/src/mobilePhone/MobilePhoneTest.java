package mobilePhone;

public class MobilePhoneTest
{
  public static void main(String[] args) {
    Phone phone = new Phone();
    //Silent state
    phone.receiveCall();
    phone.receiveMessage("Hey what's up?");
    //Vibrate state
    phone.goToVibrate();
    phone.volumeButtonDown();
    //Silent state
    phone.receiveCall();
    phone.receiveMessage("Hello there");
    phone.goToSound();
    //Sound state
    phone.receiveCall();
    phone.receiveMessage("Does this actually work?");
    phone.volumeButtonUp();
  }
}


