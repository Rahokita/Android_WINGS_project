class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListVIewオブジェクトを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // リストビューに表示するリストデータを作成
        val menuList = mutableListOf(
            "から揚げ定食", "ハンバーグ定食", "生姜焼き定食",
            "ステーキ定食", "野菜炒め定食", "とんかつ定食", "メンチカツ定食", "チキンカツ定食",
            "コロッケ定食", "回鍋肉定食", "麻婆豆腐定食", "青椒肉絲定食", "八宝菜定食",
            "酢豚定食", "豚の角煮", "焼き鳥", "焼き魚定食", "焼肉定食"
        )
        // アダプタオブジェクトを生成
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)
        // リストビューにアダプタオブジェクトを設定
        lvMenu.adapter = adapter
        //リストビューにリスナを設定
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされたときの処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            // 注文確認ダイアログフラグメントオブジェクトを生成
            val dialogFragment = OrderConfirmDialogFragment()
            // ダイアログ表示
            dialogFragment.show(supportFragmentManager,"OrderConfirmDialogFragment")

        }
    }
}
