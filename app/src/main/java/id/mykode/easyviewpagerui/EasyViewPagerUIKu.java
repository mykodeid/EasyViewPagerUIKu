package id.mykode.easyviewpagerui;
import android.content.*;
import android.util.*;
import android.support.v4.view.*;
import java.util.*;
import android.os.*;
import android.view.*;

 class EasyViewpagerUIKu extends ViewPager {
	
	//Deklarasi variabel
    private List<String> daftarJudul;
	
	//Mendapatkan Identifier R.type.name dengan string
	//sehingga saat di decompiling tidak perlu mencocokkan id public
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }
    
	//Constructor
    public EasyViewpagerUIKu (Context context, AttributeSet attrs) {
        super(context, attrs);
		
		/** Mengisi daftar list judul
		*** menambahkan daftar list judul dari Strings.xml
		***/
        daftarJudul = new ArrayList<String>();
		//daftarJudul.add(getResources().getString(R.string.judul_halaman1));
        daftarJudul.add(getResources().getString(setResource("judul_halaman1","string")));
		//daftarJudul.add(getResources().getString(R.string.judul_halaman2));
        daftarJudul.add(getResources().getString(setResource("judul_halaman2","string")));
		//daftarJudul.add(getResources().getString(R.string.judul_halaman3));
        daftarJudul.add(getResources().getString(setResource("judul_halaman3","string")));        

        //menerapkan class AdapterEasyViewpagerUIKu extends PagerAdapter
		AdapterEasyViewpagerUIKu adapter = new AdapterEasyViewpagerUIKu(daftarJudul);
		//menemukan target view berdasarkan id, R.id.id_viewpagerku
		//findViewById(R.id.id_viewpagerku)
        ViewPager mEasyViewPagerUIKu = (ViewPager) this.findViewById(setResource("id_viewpagerku","id"));
		//menge-set Animasi PageTransformer dengan CubeOutTransformer.java
        mEasyViewPagerUIKu.setPageTransformer(true, new CubeOutTransformer());
		//menge-set Adapter yang akan digunakan di ViewPager
        mEasyViewPagerUIKu.setAdapter(adapter);
		//menge-set batasan limit jumlah halaman layar sejumlah 3 halaman saja
        mEasyViewPagerUIKu.setOffscreenPageLimit(3);
    }

    //PagerAdapter untuk menghandle ViewPager
	public class AdapterEasyViewpagerUIKu extends PagerAdapter {
		//deklarasi variabel
        private List<String> adapterdaftarJudul;
		/* meminta List untuk dimasukkan ke PagerAdapter
		 * Contoh : AdapterEasyViewpagerUI(daftarJudul)
		 * AdapterEasyViewpagerUIKu adapter = new AdapterEasyViewpagerUIKu(daftarJudul);
		 *
		*/
        public AdapterEasyViewpagerUIKu(List<String> listjudul) {
            this.adapterdaftarJudul = listjudul;
        }
		
		//Override jalankan otomatis method ini
		//mendapatkan dan mengatur jumlah page
		//jumlah page 3
        @Override
        public int getCount () {
            return 3;
        }

        //Override jalankan otomatis method ini
		//meng-instantiateItem halaman yang akan ditampilkan
		//menampilkan halaman berdasarkan posisi
		@Override
        public Object instantiateItem (ViewGroup container,int position){
            //deklarasi target_idLinierLayout = 0
			int target_idLinierLayout = 0;
			//berganti posisi
            switch (position) {
				//jika posisi awal (page1)
                case 0:
					//isi id dengan R.id.id_halaman1
                    target_idLinierLayout = setResource("id_halaman1","id");
					//berhenti sejenak
                    break;
				//jika posisi pertama (page2)
                case 1:
					//isi id dengan R.id.id_halaman2
                    target_idLinierLayout = setResource("id_halaman2","id");
					//berhenti sejenak
                    break;
				//jika posisi kedua (page3)
                case 2:
					//isi id dengan R.id.id_halaman3
                    target_idLinierLayout = setResource("id_halaman3","id");
					//berhenti sejenak
                    break;
					
                /************************************************************
				 ** jika ingin menambahkan halaman
				 ** case 3:
			     **     tampilkanMenurutId = setResource("id_halaman4","id");
			     **     break;
				 ** dan seterusnya
				 ***********************************************************/
            }

            //tampilkan dengan menemukan target dengan id (target_idLinierLayout)
			return findViewById(target_idLinierLayout);
        }

        //Override jalankan otomatis method ini
		//mendapatkan judul halaman (getPageTitle)
		//sesuai posisi
		@Override
        public CharSequence getPageTitle ( int position){
            return adapterdaftarJudul.get(position);
        }

        @Override
        public boolean isViewFromObject (View arg0, Object arg1){
            return arg0 ==  arg1;
        }

        @Override
        public Parcelable saveState () {
            return null;
        }
    }
}

/****************************************************************************
 * Hal - hal yang perlu diedit jika ingin menambahkan halaman
 ****************************************************************************
 * daftarJudul.add(getResources().getString(setResource("judul_halaman4","string")));
 ****************************************************************************
 * tambahkan juga di strings.xml sesuaikan dengan urutannya
 ****************************************************************************
 * mEasyViewPagerUIKu.setOffscreenPageLimit(4);
 ****************************************************************************
 * @Override
        public int getCount () {
            return 4;
        }
 ****************************************************************************	
 * case 3:
	tampilkanMenurutId = setResource("id_halaman4","id");
	break;
 ****************************************************************************
 * tambahkan juga di main.xml sesuaikan dengan urutannya
 ****************************************************************************
 */


