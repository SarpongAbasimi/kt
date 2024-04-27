package com.example.learntogether.data

import com.example.learntogether.R
import com.example.learntogether.model.Affirmation
import com.example.learntogether.model.ImageResourceId
import com.example.learntogether.model.StringResourceId

class AffirmationData {
    fun loadAffirmation(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(StringResourceId(R.string.body_four), ImageResourceId(R.drawable.ic_launcher_background)),
            Affirmation(StringResourceId(R.string.body_three), ImageResourceId(R.drawable.dice_4)),
            Affirmation(StringResourceId(R.string.body_two), ImageResourceId(R.drawable.dice_5)),
            Affirmation(StringResourceId(R.string.title), ImageResourceId(R.drawable.dice_1)),
            Affirmation(StringResourceId(R.string.title_one), ImageResourceId(R.drawable.ic_launcher_foreground)),
            Affirmation(StringResourceId(R.string.learn_together_title), ImageResourceId(R.drawable.dice_5)),
            Affirmation(StringResourceId(R.string.all_tasks_text_one), ImageResourceId(R.drawable.ic_task_completed)),
            Affirmation(StringResourceId(R.string.bill_amount), ImageResourceId(R.drawable.dice_6)),
            Affirmation(StringResourceId(R.string.tip_time_amount), ImageResourceId(R.drawable.dice_1)),
            Affirmation(StringResourceId(R.string.text_two), ImageResourceId(R.drawable.dice_2)),
        )
    }
}