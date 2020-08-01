<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/calendar_constum">

    <android.support.v7.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:cardCornerRadius="5dp"
        android:layout_marginTop="10dp"
        android:layout_marginRight="5dp"
        android:layout_marginLeft="5dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal"
            android:padding="8dp"
            android:background="@color/colorRed"
            android:paddingBottom="8dp">

            <ImageButton
                android:layout_width="30dp"
                android:layout_height="30dp"
                android:id="@+id/atrasbtn"
                android:background="@drawable/atras"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:layout_marginTop="4dp"
                android:text="currente date"
                android:textColor="#FFFFFF"
                android:textSize="18dp"
                android:textStyle="bold"
                android:layout_weight="3"
                android:id="@+id/current_date"/>

            <ImageButton
                android:layout_width="30dp"
                android:layout_height="30dp"
                android:id="@+id/nextbtn"
                android:background="@drawable/next"/>

        </LinearLayout>
    </android.support.v7.widget.CardView>


    <android.support.v7.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="5dp"
        android:layout_marginTop="10dp"
        android:layout_marginRight="5dp"
        android:layout_marginLeft="5dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:paddingTop="4dp"
            android:paddingBottom="4dp"
            android:background="@color/colorPrimaryDark">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Sun"
                android:background="@color/colorYellow"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="@color/colorDark"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Mon"
                android:background="@color/colorPrimary"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="#FFFFFF"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Tue"
                android:background="@color/colorPrimary"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="#FFFFFF"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Wed"
                android:background="@color/colorPrimary"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="#FFFFFF"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Thu"
                android:background="@color/colorPrimary"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="#FFFFFF"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:text="Fri"
                android:background="@color/colorPrimary"
                android:layout_marginTop="4dp"
                android:textStyle="bold"
                android:layout_weight="1"
                android:textColor="#FFFFFF"/>

            <TextView
                android:layout_width="wrap_content"
       