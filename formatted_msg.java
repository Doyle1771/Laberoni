import java.io.*;
import java.util.Scanner;
public class formatted_msg implements Serializable{
  public enum CTRL { NORMAL, TERMINATE, LOOPBACK, BROADCAST, SETUP, GET_ALL_CLIENTS};
  String dest;
  String msg;
  CTRL msg_ctrl;
  public formatted_msg (String dst, String msg){
    this.msg = msg;
    dest = dst;
    msg_ctrl = CTRL.NORMAL;
  }
  public void set_terminate() { msg_ctrl = CTRL.TERMINATE; }
  public void set_loopback() { msg_ctrl = CTRL.LOOPBACK; }
  public void set_broadcast(){msg_ctrl = CTRL.LOOPBACK;}
  public void set_setup(){msg_ctrl = CTRL.SETUP;}
  public void set_get_all_clients(){msg_ctrl = CTRL.GET_ALL_CLIENTS;}
  public void set_ctrl(CTRL ctrl) { msg_ctrl = ctrl; }
  public String toString(){
    String str = "formatted_msg to " + dest + " msg: " + msg;
    switch (msg_ctrl) {
      case NORMAL: str += " NORMAL"; break;
      case TERMINATE: str += " TERMINATE"; break;
      case LOOPBACK: str += " LOOPBACK"; break;
      case BROADCAST: str += " BROADCAST"; break;
      case SETUP: str += " SETUP"; break;
      case GET_ALL_CLIENTS: str += " GET_ALL_CLIENTS"; break;
    }
    return str;
  }
  static formatted_msg init(){

    formatted_msg msg1;
    String dest;
    String type;
    String cont;
    System.out.println("Please enter message type");
    Scanner sc = new Scanner(System.in);
    type=sc.nextLine();
    System.out.println("Please enter message destination");
    dest=sc.nextLine();
    System.out.println("Please enter message content");
    cont=sc.nextLine();
    msg1= new formatted_msg(dest, cont);
    if(type.equals("TERMINATE")){
      msg1.set_terminate();
    }else if(type.equals("LOOPBACK")){
      msg1.set_loopback();
    }else if(type.equals("BROADCAST")){
      msg1.set_broadcast();
    }else if(type.equals("SETUP")){
      msg1.set_setup();
    }else if(type.equals("GET_ALL_CLIENTS")){
      msg1.set_get_all_clients();
    }
    
    return msg1;
  };

}
