package com.example.gt_3m_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gt_3m_6.databinding.FragmentMusicBinding


class MusicFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentMusicBinding
    private lateinit var musicList: ArrayList<Music>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = MusicAdapter(musicList, this)
        binding.recyclerView.adapter = adapter

    }

    private fun loadData() {
        musicList = ArrayList()
        musicList.add(Music("Blank Space", "Taylor Swift", 5))
        musicList.add(Music("Watch Me", "Silento", 15))
        musicList.add(Music("Earned It", "The Weekend", 300))
        musicList.add(Music("The Hills", "The Weekend", 145))
        musicList.add(Music("Writing’s On The Wall", "The Hils", 55))
        musicList.add(Music("Blank Space", "Taylor Swift", 32))
        musicList.add(Music("Watch Me", "Silento", 65))
        musicList.add(Music("Earned It", "The Weekend", 234))
        musicList.add(Music("The Hills", "The Weekend", 765))
        musicList.add(Music("Writing’s On The Wall", "The Hils", 432))


    }

    override fun onClick(name: String) {
        val bundle = Bundle()
        bundle.putString("MUSIC", name)
        val fragment: Fragment = MusicInfoFragment()
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).addToBackStack(null).commit()

    }


}