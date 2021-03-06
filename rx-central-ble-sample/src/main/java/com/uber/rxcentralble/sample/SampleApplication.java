package com.uber.rxcentralble.sample;

import android.app.Application;
import com.uber.rxcentralble.ConnectionManager;
import com.uber.rxcentralble.GattManager;
import com.uber.rxcentralble.Utils;
import com.uber.rxcentralble.core.CoreBluetoothDetector;
import com.uber.rxcentralble.core.CoreConnectionManager;
import com.uber.rxcentralble.core.CoreGattIO;
import com.uber.rxcentralble.core.CoreGattManager;

import java.util.UUID;

public class SampleApplication extends Application {

  public static final UUID GAP_SVC_UUID = Utils.uuidFromInteger(0x1800);
  public static final UUID GAP_DEVICE_NAME_UUID = Utils.uuidFromInteger(0x2A00);
  public static final UUID BATTERY_SVC_UUID = Utils.uuidFromInteger(0x180F);
  public static final UUID BATTERY_LEVEL_UUID = Utils.uuidFromInteger(0x2A19);
  public static final UUID DIS_SVC_UUID = Utils.uuidFromInteger(0x180A);
  public static final UUID DIS_MFG_NAME_UUID = Utils.uuidFromInteger(0x2A29);
  public static final UUID DIS_MODEL_UUID = Utils.uuidFromInteger(0x2A24);
  public static final UUID DIS_SERIAL_UUID = Utils.uuidFromInteger(0x2A25);
  public static final UUID DIS_HARDWARE_UUID = Utils.uuidFromInteger(0x2A27);
  public static final UUID DIS_FIRMWARE_UUID = Utils.uuidFromInteger(0x2A26);

  private ConnectionManager connectionManager;
  private GattManager gattManager;

  @Override
  public void onCreate() {
    super.onCreate();

    gattManager = new CoreGattManager();
    connectionManager = new CoreConnectionManager(this,
            new CoreBluetoothDetector(this),
            new CoreGattIO.Factory());
  }

  public ConnectionManager getConnectionManager() {
    return connectionManager;
  }

  public GattManager getGattManager() {
    return gattManager;
  }
}
