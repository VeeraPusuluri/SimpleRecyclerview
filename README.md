# SimpleRecyclerview

Step 1:
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  Step 2:
  Add the dependency in app build.gradle file.

	dependencies {
	        implementation 'com.github.VeeraPusuluri:SimpleRecyclerview:1.0.0'
	}
  
  Step 3:
  Add Recyclerview to the Layout
  
  <com.veera.android.widget.recyclerview.CustomRecyclerView
          android:id="@+id/recyclerview" 
          android:layout_width="match_parent" 
          android:layout_height="wrap_content"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layoutManager="LinearLayoutManager"
          android:tag="layout/activity_recyclerview_0"/>
          
   Step 4:
   Submit data to adapter and assign to RecyclerView
   
   private lateinit var recyclerviewAdapter: RecyclerviewAdapterMain
   lateinit var customRecyclerView: CustomRecyclerView
    
   override fun onCreate(savedInstanceState: Bundle?) {
            setContentView(bindng.root)
          
        recyclerviewAdapter = RecyclerviewAdapterMain{}
        recyclerviewAdapter.submitList(recyclerviewData)
        customRecyclerView = findViewById(R.id.recyclerview)
        customRecyclerView.adapter = recyclerviewAdapter
        
   }
          
