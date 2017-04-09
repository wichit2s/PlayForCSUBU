package controllers;

import play.mvc.*;
import play.Logger; // 1. import Logger

import views.html.*;


/**
 * ตัวอย่าง controller เพื่อแสดงวิธีการใช้ Log เพื่อบันทึกผลการทำงานของโปรแกรม.
 * โดยปกติเราใช้ System.out.println() ในการตรวจผลการทำงานของโปรแกรม ในโปรแกรม
 * ที่มีขนาดเล็กไม่ซับซ้อน แต่เมื่อโปรแกรมซับซ้อนและมีการทำงานเป็นกลุ่มการใช้ System.out.println 
 * จะมีข้อจำกัดหรือต้องทำงานเพิ่มเพื่อที่จะสามารถทำส่งต่อไปนี้ได้
 *
 * 1. แบ่งประเภทข้อความที่บันทึก หรือ ระดับของข้อความที่บันทึกได้ เช่น debug, warn, error
 *
 * 2. บอกได้ว่าข้อความนั้นมาจากคลาสใด
 *
 * 3. การบันทึกลงไฟล์เพื่อการตววจสอบด้วยสายตา หรือ การใช้คำสั่งตรวจในภายหลัง 
 * 
 */
public class LoggingController extends Controller {

  /**
   * 2. สร้าง Log สำหรับคลาสนี้
   */
  static final Logger.ALogger logger = Logger.of(LoggingController.class);

  public long หารร่วมมาก(long a, long b) {
    logger.debug("กำลังหา หารร่วมมาก({}, {})", a, b);
    if (b > a) {
      return หารร่วมมาก(b, a);
    } else if (b == 0) {
      return a;
    } else {
      return หารร่วมมาก(b, a%b);
    }
  }

    /**
     * 3. ใช้งาน Logger.
     */
    public Result gcd(long a, long b) {
      long r = หารร่วมมาก(a,b);
      logger.info("{}", gcd.render(a, b, r));
        return ok(gcd.render(a, b, r));
    }
}
