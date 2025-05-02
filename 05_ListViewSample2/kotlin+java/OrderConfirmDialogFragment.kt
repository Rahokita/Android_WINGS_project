class OrderConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    // アクティビティがnullでないならば、ダイアログオブジェクトを生成
        val dialog = activity?.let{
            val builder = AlertDialog.Builder(it)
            // ダイアログのタイトルを設定
            builder.setTitle(R.string.dialog_title)
            // ダイアログのメッセージを設定
            builder.setMessage(R.string.dialog_msg)
            // Positive Button の設定
            builder.setPositiveButton(R.string.dialog_btn_ok,DialogButtonClickListener())
            // Negative Button の設定
            builder.setNegativeButton(R.string.dialog_btn_ng,DialogButtonClickListener())
            // Neutral Button の設定
            builder.setNeutralButton(R.string.dialog_btn_nu,DialogButtonClickListener())
            // ダイアログオブジェクトを生成
            builder.create()
        }
        // 生成したダイアログオブジェクトをリターン
        return dialog ?: throw IllegalStateException("アクティビティがNullです")
    }
    
    private inner class DialogButtonClickListener : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            // トーストメッセージ用文字列変数を用意
            var msg = ""
            // タップされたアクションボタンで分岐
            when(which){
                // Positive Buttonならば
                DialogInterface.BUTTON_POSITIVE ->
                    // 注文用のメッセージを格納
                    msg = getString(R.string.dialog_ok_toast)
                DialogInterface.BUTTON_NEGATIVE ->
                    // キャンセル用のメッセージを格納
                    msg = getString(R.string.dialog_ng_toast)
                DialogInterface.BUTTON_NEUTRAL ->
                    // 問い合わせ用のメッセージを格納
                    msg = getString(R.string.dialog_nu_toast)
            }
            // トーストの表示
            Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
        }
    }

}
