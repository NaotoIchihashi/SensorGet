package jp.sb.naoto.ichihashi.sensorget

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //StringBuilderクラスのインスタンス取得
        //StringBuilderは一度代入した文字列の再操作（追加・挿入・変更）が可能
        val buffer = StringBuilder()

        //SensorManagerクラスのインスタンス生成
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        //Sensor全ての一覧をListで取得
        val sList:List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        //取得したListから各Sensorオブジェクトを取得
        for(sensor:Sensor in sList){
            buffer.append("${sensor.stringType},${sensor.name},${sensor.vendor}\n")
        }
        txt1.text = buffer.toString()
    }
}
