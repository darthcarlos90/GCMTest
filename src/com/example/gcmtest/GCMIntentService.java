package com.example.gcmtest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {

	@Override
	protected void onError(Context arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String messaje = arg1.getStringExtra("message");
		newNotification(messaje);

	}

	@Override
	protected void onRegistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	protected void newNotification(String mensaje) {
		Notification.Builder mBuilder = new Notification.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher).setContentTitle("Alerta")
				.setContentText(mensaje).setSubText("Notificación de prueba");

		// TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		// stackBuilder.addParentStack(WS.class);
		// stackBuilder.addNextIntent(intent);
		// PendingIntent resultPendingIntent = stackBuilder
		// .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		// mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());
	}

}
