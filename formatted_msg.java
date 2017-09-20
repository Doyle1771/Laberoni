import java.io.*;
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
  static formatted_msg init(formatted_msg msg){
    return msg;
  };
}
