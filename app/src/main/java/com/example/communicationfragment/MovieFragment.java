package com.example.communicationfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment
{
    private RecyclerView movieListView;
    private MovieAdapter movieAdapter;
    private List<MovieModel> listMovieModel = new ArrayList<>();
    public static final String KEY_PARCEABLE = "parcel";
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dummyData(listMovieModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View mView, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(mView, savedInstanceState);
        movieListView = mView.findViewById(R.id.listMovie);
        movieListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mContext = getActivity().getApplicationContext();
        movieAdapter = new
                MovieAdapter(mContext,listMovieModel,getActivity().getSupportFragmentManager());
        movieListView.setAdapter(movieAdapter);
        movieAdapter.SetListModel(listMovieModel);
    }

    private void dummyData(List<MovieModel> listMovieModel)
    {
        listMovieModel.add(new MovieModel("Spider-Man: Far from Home",R.drawable.spiderman,"Action","78","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        listMovieModel.add(new MovieModel("The Lion King",R.drawable.lionking,"Animation","67","Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his."));
        listMovieModel.add(new MovieModel("Toy Story4",R.drawable.toystory,"Animation","77","Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called Forky to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        listMovieModel.add(new MovieModel("Avengers: Endgame",R.drawable.avengerss,"Animation","84","After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        listMovieModel.add(new MovieModel("Crawl",R.drawable.crawl,"Action","60","While struggling to save her father during a Category 5 hurricane, a young woman finds herself trapped inside a flooding house and fighting for her life against Florida’s most savage and feared predators."));
        listMovieModel.add(new MovieModel("Annabelle Comes Home",R.drawable.annabellee,"Horror","60","Determined to keep Annabelle from wreaking more havoc, demonologists Ed and Lorraine Warren bring the possessed doll to the locked artifacts room in their home, placing her “safely” behind sacred glass and enlisting a priest’s holy blessing. But an unholy night of horror awaits as Annabelle awakens the evil spirits in the room, who all set their sights on a new target—the Warrens' ten-year-old daughter, Judy, and her friends."));
        listMovieModel.add(new MovieModel("Men in Black: Internationa",R.drawable.mib,"Action","60","The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization."));
        listMovieModel.add(new MovieModel("Shaft ",R.drawable.shaft,"Action","64","JJ, aka John Shaft Jr., may be a cyber security expert with a degree from MIT, but to uncover the truth behind his best friend’s untimely death, he needs an education only his dad can provide. Absent throughout JJ’s youth, the legendary locked-andloaded John Shaft agrees to help his progeny navigate Harlem’s heroin-infested underbelly."));
        listMovieModel.add(new MovieModel("Yesterday",R.drawable.yesterday,"Drama","66","Jack Malik is a struggling singer-songwriter in an English seaside town whose dreams of fame are rapidly fading, despite the fierce devotion and support of his childhood best friend, Ellie. After a freak bus accident during a mysterious global blackout, Jack wakes up to discover that he's the only person on Earth who can remember The Beatles."));
        listMovieModel.add(new MovieModel("Stuber",R.drawable.stuber,"Action","64","After crashing his car, a cop who's recovering from eye surgery recruits an Uber driver to help him catch a heroin dealer. The mismatched pair soon find themselves in for a wild day of stakeouts and shootouts as they encounter the city's seedy side."));
        listMovieModel.add(new MovieModel("Anna",R.drawable.anna,"Action","60","Beneath Anna Poliatova's striking beauty lies a secret that will unleash her indelible strength and skill to become one of the world's most feared government assassins."));
    }
}
