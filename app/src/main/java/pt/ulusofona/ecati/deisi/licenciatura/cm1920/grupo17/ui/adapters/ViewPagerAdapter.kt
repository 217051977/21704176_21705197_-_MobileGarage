package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var fragments: MutableList<Fragment> = mutableListOf()
    private var fragmentsTitles: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragmentsTitles.size

    override fun getPageTitle(position: Int):
            CharSequence = fragmentsTitles.get(position)

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentsTitles.add(title)
    }
}