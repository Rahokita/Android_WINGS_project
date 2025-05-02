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

}
