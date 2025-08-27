# Firefox TV Shortcut

This is a simple Android TV / NVIDIA SHIELD app that acts as a **shortcut to launch Firefox**.
It provides a proper Android TV banner (for the home screen and favorites row) and an adaptive app icon so the app looks correct in the SHIELD launcher.

## Features
- Launches **Firefox for Android** directly from the SHIELD home screen
- Shows up with a **custom app icon** (adaptive icon with background + logo)
- Provides a **320×180 TV banner** so it displays correctly in the Favorites row and Apps screen
- Lightweight – no extra UI, just forwards into Firefox

---

## Prerequisites

- **Android Studio** (latest version recommended)
- **Android SDK + Platform Tools** installed (for `adb`)
- NVIDIA SHIELD or Android TV device
- (Optional) `adb` installed on your development machine if you want to sideload via terminal

---

## Building the APK

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/FirefoxTVShortcut.git
   cd FirefoxTVShortcut
   ```
   
2. Open the project in **Android Studio**.

3. Build the APK:
    - From the top menu: **Build → Build Bundle(s) / APK(s) → Build APK(s)**
    - Or via terminal:
      ```bash
      ./gradlew assembleDebug
      ```

4. The APK will be generated at:
   ```
   app/build/outputs/apk/debug/app-debug.apk
   ```

---

## Installing on SHIELD / Android TV

### Option A: Using Android Studio
- Connect your SHIELD (via USB or network ADB).
- Click **Run** in Android Studio to install directly.

### Option B: Using `adb`
1. Enable **Developer Options** on your SHIELD:
    - Settings → Device Preferences → About → tap **Build number** 7 times
    - Settings → Developer Options → enable **USB debugging** or **Network debugging**

2. Connect to the device:
   ```bash
   adb connect <SHIELD_IP>:5555
   ```

3. Install the APK:
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

---

## Project Structure

```
app/src/main/res/
  mipmap-anydpi-v26/ic_launcher.xml          # Adaptive icon wrapper
  mipmap-xxxhdpi/ic_launcher_foreground.png  # Foreground logo (square)
  values/colors.xml                          # Icon background color
  drawable-nodpi/tv_banner.png               # 320x180 banner for Android TV
```

- **ic_launcher.xml** → defines adaptive icon (white background + logo)
- **tv_banner.png** → displayed in the SHIELD launcher Apps grid & Favorites row

---

## Notes

- `tv_banner.png` must be **exactly 320×180 px** and stored in `drawable-nodpi/`.
- Always **uninstall old builds** before reinstalling to avoid cached banners:
  ```bash
  adb uninstall com.example.firefoxtvshortcut
  adb install app/build/outputs/apk/debug/app-debug.apk
  ```
- If icons/banners don’t update, clear the SHIELD launcher cache:
  Settings → Apps → See all apps → **Android TV Home** → Clear Cache (and Data if needed).

---

## Updating Firefox (sideloaded)
If Firefox was sideloaded, it won’t auto-update via Play Store. To update:
```bash
adb install -r /path/to/new/firefox.apk
```
(Use `-d` if downgrading versionCode.)

---

## License
MIT License – use, modify, and share freely.
