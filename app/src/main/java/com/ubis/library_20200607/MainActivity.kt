package com.ubis.library_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : baseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    override fun setValues() {
        Glide.with(mContext).load("https://news.kbs.co.kr/data/news/2019/01/16/4117160_uS4.jpg").into(profileiu)
    }

    override fun setEvents() {
        profileiu.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileActivity::class.java)
            startActivity(myIntent)
        }

        collBtn.setOnClickListener {
            // 전화를 걸기전에 권한을 얻었는지 체크
            // 권한을 허가 받은 경우에만 전화를 검
            val permissionlistener = object : PermissionListener{
                override fun onPermissionGranted() { // 허가가 난 경우
                    // 실제로 전화 거는 고드
                    val MyUrl = Uri.parse("tel:${PhonenumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, MyUrl)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    // 허가가 안난 경우
                    Toast.makeText(mContext, "권한이 거부되어 통화를 할수없습니다.", Toast.LENGTH_SHORT)
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("거절되면 통화할수없으니 설정에서 권한을 해제해 주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
}
