package org.runite.client;
import org.rs09.client.config.GameConfig;
import org.rs09.client.console.DeveloperConsole;
import org.rs09.client.data.ReferenceCache;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class KeyboardListener implements KeyListener, FocusListener {

   static int[] KEY_CODE_MAP = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   static boolean aBoolean1905 = true;
   static int anInt1908 = 0;
   static ReferenceCache aReferenceCache_1911 = new ReferenceCache(260);
   static int loginThemeSongArchiveID;
   static int anInt1914;
   static CacheIndex aClass153_1916;
   static int anInt1918 = 0;
   static int anInt2384 = 0;
   static int[] anIntArray1978 = new int[128];

    static void adjustKeyCodeMap() {
         if(!Signlink.javaVendor.toLowerCase().contains("microsoft")) {
            if(null == Signlink.setTraversalKeysEnabled) {
               KEY_CODE_MAP[192] = 58;
               KEY_CODE_MAP[222] = 59;
            } else {
               KEY_CODE_MAP[222] = 58;
               KEY_CODE_MAP[192] = 28;
               KEY_CODE_MAP[520] = 59;
            }

            KEY_CODE_MAP[45] = 26;
            KEY_CODE_MAP[61] = 27;
            KEY_CODE_MAP[91] = 42;
            KEY_CODE_MAP[59] = 57;
            KEY_CODE_MAP[93] = 43;
            KEY_CODE_MAP[44] = 71;
            KEY_CODE_MAP[92] = 74;
            KEY_CODE_MAP[46] = 72;
            KEY_CODE_MAP[47] = 73;
         } else {
            KEY_CODE_MAP[187] = 27;
            KEY_CODE_MAP[223] = 28;
            KEY_CODE_MAP[221] = 43;
            KEY_CODE_MAP[188] = 71;
            KEY_CODE_MAP[222] = 59;
            KEY_CODE_MAP[192] = 58;
            KEY_CODE_MAP[191] = 73;
            KEY_CODE_MAP[219] = 42;
            KEY_CODE_MAP[190] = 72;
            KEY_CODE_MAP[186] = 57;
            KEY_CODE_MAP[220] = 74;
            KEY_CODE_MAP[189] = 26;
         }
   }

public char getSpecial(char c){
       switch(c){
          case '1':
             return '!';
          case '2':
             return '@';
          case '3':
             return '#';
          case '4':
             return '$';
          case '5':
             return '%';
          case '6':
             return '^';
          case '7':
             return '&';
          case '8':
             return '*';
          case '9':
             return '(';
          case '0':
             return ')';
          case '-':
             return '_';
          case '=':
             return '+';
          case '[':
             return '{';
          case ']':
             return '}';
          case ';':
             return ':';
          case '\'':
             return '"';
          case ',':
             return '<';
          case '.':
             return '>';
          case '/':
             return '?';
          case '\\':
             return '|';
       }
   return '~';
}

public boolean isSpecial(char c){
   String specialChars = "/*!@#$%^&*:();\"{}_[+=-_]'|\\?/<>,.";
       if(Character.isDigit(c) || specialChars.contains(""+c)){
           return true;
       }
    return false;
}

boolean capitalize = false;

   public final synchronized void keyPressed(KeyEvent e) {
      try {
         System.out.println("Key code: " + e.getKeyCode());
         switch (e.getKeyCode())
         {
            case 39: // Issue with 39 being right arrow and also something sent by the ' and " characters.
               return;
            case 16:
               MouseWheel.shiftDown = true;
               break;
            case 17:
               MouseWheel.ctrlDown = true;
               break;
            case 116:
               Client.ZOOM -= 20;
               return;
            case 115:
               Client.ZOOM += 20;
               return;
            case 120:
               //Cam On
               new isMiddleMouse(true);
               return;
            case 118:
               new isHeldPress(true);
               return;
            case 117:
               new isHeldPress(false);
               return;
            case 119:
               //Cam Off
               new isMiddleMouse(false);
               return;
            case 121:
               if(isRightClick.getState()){
                  new isRightClick(false);
               }
               return;
            case 122:
               if(!isRightClick.getState()){
                  new isRightClick(true);
               }
               return;
            case 123:
               capitalize = true;
               return;

         }

         if(null != TextureOperation33.aClass148_3049) {
            TextureOperation29.anInt3398 = 0;
            int var2 = e.getKeyCode();
            if(0 <= var2 && KEY_CODE_MAP.length > var2) {
               var2 = KEY_CODE_MAP[var2];
               // System.out.println(var2);
               if(0 != (var2 & 128)) {
                  var2 = -1;
               }
            } else {
               var2 = -1;
            }
            
            
            
            /**
             * Tab to reply
             */
			if (e.getKeyCode() == KeyEvent.VK_TAB) {
				ClientCommands.ClientCommands(RSString.parse("::reply"));
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
               ClientCommands.ClientCommands(RSString.parse("::shutdowninterface"));
            }
			
			//causing issues when in other interfaces, such as GE interface. My quick thing impl didn't work - Jamix77
			
			/**if (var1.getKeyCode() == KeyEvent.VK_SPACE)
            {
               Class2.method78(40, false, 0);
            }**/
			
            
            /**
             * Controls arrow key mouse movement
             */
            if(anInt2384 >= 0 && var2 >= 0) {
               Unsorted.anIntArray2952[anInt2384] = var2;
               anInt2384 = 127 & anInt2384 - -1;
               if(anInt2384 == Class32.anInt1744) {
                  anInt2384 = -1;
               }
            }

            int var3;
            if(var2 >= 0) {
               var3 = 127 & 1 + Class25.anInt491;
               if(var3 != Class3_Sub28_Sub9.anInt3620) {
                  Class129.anIntArray1693[Class25.anInt491] = var2;
                  anIntArray1978[Class25.anInt491] = -1;
                  Class25.anInt491 = var3;
               }
            }

            var3 = e.getModifiers();
            if((var3 & 10) != 0 || 85 == var2 || var2 == 10) {
               e.consume();
            }
         }

      } catch (RuntimeException var4) {
         throw ClientErrorException.clientError(var4, "uf.keyPressed(" + (e != null?"{...}":"null") + ')');
      }
   }

   public final void keyTyped(KeyEvent var1) {
      if (DeveloperConsole.INSTANCE.getOpen()) {
         DeveloperConsole.INSTANCE.handleKeyPressed(var1);
         return;
      }
      switch(var1.getKeyCode()){
         case 117:
         case 118:
         case 119:
         case 120:
         case 123:
            return;
      }
      if(capitalize){
         capitalize = false;
         System.out.println("Replacing"+var1.getKeyCode());
         System.out.println("Replacing"+var1.getKeyChar());
         if(isSpecial(var1.getKeyChar())){
            var1.setKeyChar(getSpecial(var1.getKeyChar()));
         } else {
            var1.setKeyChar(Character.toUpperCase(var1.getKeyChar()));
         }
         System.out.println("with"+var1.getKeyChar());
      }
      if(var1.isAltDown()){
         if(var1.getKeyChar()=='n'){
            GameConfig.NPC_DEBUG_ENABLED = !GameConfig.NPC_DEBUG_ENABLED;
            BufferedDataStream.addChatMessage(RSString.parse("<img=2>Client debug notifier"), 0, RSString.parse("NPC debug context " + (GameConfig.NPC_DEBUG_ENABLED ? "enabled." : "disabled.")), -1);
            return;
         }
         if(var1.getKeyChar()=='o'){
            GameConfig.OBJECT_DEBUG_ENABLED = !GameConfig.OBJECT_DEBUG_ENABLED;
            BufferedDataStream.addChatMessage(RSString.parse("<img=2>Client debug notifier"), 0, RSString.parse("Object debug context " + (GameConfig.OBJECT_DEBUG_ENABLED ? "enabled." : "disabled.")), -1);
            return;
         }
         if(var1.getKeyChar()=='i'){
            GameConfig.ITEM_DEBUG_ENABLED = !GameConfig.ITEM_DEBUG_ENABLED;
            BufferedDataStream.addChatMessage(RSString.parse("<img=2>Client debug notifier"), 0, RSString.parse("Item debug context " + (GameConfig.ITEM_DEBUG_ENABLED ? "enabled." : "disabled.")), -1);
            return;
         }
         return;
      }
      try {
    	 
         if(TextureOperation33.aClass148_3049 != null) {
            int var2 = CSConfigCachefile.method1386(var1);
            if(var2 >= 0) {
               int var3 = 1 + Class25.anInt491 & 127;
               if(var3 != Class3_Sub28_Sub9.anInt3620) {
                  Class129.anIntArray1693[Class25.anInt491] = -1;
                  anIntArray1978[Class25.anInt491] = var2;
                  Class25.anInt491 = var3;
               }
            }
         }

         var1.consume();
      } catch (RuntimeException var4) {
         throw ClientErrorException.clientError(var4, "uf.keyTyped(" + (var1 != null?"{...}":"null") + ')');
      }
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(TextureOperation33.aClass148_3049 != null) {
         anInt2384 = -1;
      }
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if (DeveloperConsole.INSTANCE.getOpen()) {
         return;
      }

      switch (var1.getKeyCode())
      {
         case 16:
            MouseWheel.shiftDown = false;
            break;
         case 17:
            MouseWheel.ctrlDown = false;
            break;
      }
      try {
         if(null != TextureOperation33.aClass148_3049) {
            TextureOperation29.anInt3398 = 0;
            int var2 = var1.getKeyCode();
            if(var2 >= 0 && var2 < KEY_CODE_MAP.length) {
               var2 = KEY_CODE_MAP[var2] & -129;
            } else {
               var2 = -1;
            }

            if(anInt2384 >= 0 && var2 >= 0) {
               Unsorted.anIntArray2952[anInt2384] = ~var2;
               anInt2384 = 127 & 1 + anInt2384;
               if(anInt2384 == Class32.anInt1744) {
                  anInt2384 = -1;
               }
            }
         }

         var1.consume();
      } catch (RuntimeException var3) {
         throw ClientErrorException.clientError(var3, "uf.keyReleased(" + "{...}" + ')');
      }
   }

   public final void focusGained(FocusEvent var1) {}

}
