# Android開発の学習

## bindingについて
### 実装手順1: 有効化
`app/build.gradle` の android {} ブロックのに`viewBinding`を追加。
これにより、Bindingクラスが生成されるようになる。
```
android {
    ...
    viewBinding {
        enable = true
    }
}
```
または、
ビルド時に、例えば、`activity_main.xml`に対して、`ActivityMainBinding`クラスが自動生成される。

### 実装手順2: 実装
MainActivity.kt
```
class MainActivity : AppCompatActivity() {

    // binding変数を作る
    // lateinit：あとで初期化することを宣言する。
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layoutInflaterを渡してインスタンスを作る。
        // inflate()：実際のViewを作る。
        // layoutInflater：Activityクラスに用意されているプロパティ。XMLをViewに変換する。
        binding = ActivityMainBinding.inflate(layoutInflater)

        // ActivityにUIを表示する。
        // binding.root: レイアウト全体のビュー（ConstraintLayoutなど）
        setContentView(binding.root)

        // findViewByIdは不要
        binding.tvHello.text = "こんにちは！ViewBinding！"
    }
}
```

フラグメント
```
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // メモリリーク防止！
    }
}
```
