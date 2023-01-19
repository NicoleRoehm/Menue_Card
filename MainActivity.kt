package com.example.speisekarteapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.speisekarteapp.databinding.ActivityMainBinding
import kotlin.math.round

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
const val TAG = "MainActivity"



class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */
      private var bill: Float = 0f
      private val drink1 = Drink("Kaffee", 3.95f)
      private val drink2 = Drink("Wein", 4.23f)
      private val drink3 = Drink("Cocktail", 6.93f)


    /* -------------------- Lifecycle -------------------- */
    /**
     * Lifecycle Funktion, wird aufgerufen wenn Activity erstellt wird
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called")
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            drink1.count = savedInstanceState.getInt("drink1")
            drink2.count = savedInstanceState.getInt("drink2")
            drink3.count = savedInstanceState.getInt("drink3")
            bill = savedInstanceState.getFloat("bill")

        }


            // Lege hier die Binding Variable an
            val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)

            // Setze hier die Namen, Preise und Count in der View über die binding Variable
            binding.drink1Name.text = drink1.name
            binding.drink2Name.text = drink2.name
            binding.drink3Name.text = drink3.name

            binding.drink1Price.text = "%.2f".format(drink1.price)
            binding.drink2Price.text = "%.2f".format(drink2.price)
            binding.drink3Price.text = "%.2f".format(drink3.price)

            binding.drink1Count.text = drink1.count.toString()
            binding.drink2Count.text = drink2.count.toString()
            binding.drink3Count.text = drink3.count.toString()
            binding.totalPrice.text = bill.toString() // Todo richtige bill anzeigen lassen

            // implementiere einen onClicklistener für das Kaffee Icon
            binding.drink1Button.setOnClickListener {
                try {
                    addToBill(drink1.price)
                    drink1.count++
                    binding.drink1Count.text = drink1.count.toString()
                    binding.totalPrice.text = "%.2f".format(bill)
                } catch (ex: Exception) {
                    Log.e(TAG, "Something went wrong: $ex")
                }
            }

            // implementiere einen onClicklistener für das Wein Icon
            binding.drink2Button.setOnClickListener {
                try {
                    addToBill(drink2.price)
                    drink2.count++
                    binding.drink2Count.text = drink2.count.toString()
                    binding.totalPrice.text = "%.2f".format(bill)
                } catch (ex: Exception) {
                    Log.e(TAG, "Something went wrong: $ex")
                }
            }

            // implementiere einen onClicklistener für das Cocktail Icon
            binding.drink3Button.setOnClickListener {
                try {
                    addToBill(drink3.price)
                    drink3.count++
                    binding.drink3Count.text = drink3.count.toString()
                    binding.totalPrice.text = "%.2f".format(bill)
                } catch (ex: Exception) {
                    Log.e(TAG, "Something went wrong: $ex")
                }
            }

            // implementiere einen onClicListener für den ResetButton
            binding.resetButton.setOnClickListener {
                drink1.count = 0
                drink2.count = 0
                drink3.count = 0
                bill = 0f

                binding.drink1Count.text = drink1.count.toString()
                binding.drink2Count.text = drink2.count.toString()
                binding.drink3Count.text = drink3.count.toString()
                binding.totalPrice.text = "0.00"
            }
        }

        /**
         * Diese Funktion addiert den Preis zur Rechnung
         */
        private fun addToBill(price: Float?) {
            if (price != null) {
                bill += price
                bill = round(bill * 100) / 100
            }
        }
    override fun onStart() {
        Log.d(TAG, "onStart called")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart called")
        super.onRestart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy called")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("drink1", drink1.count)
        outState.putInt("drink2", drink2.count)
        outState.putInt("drink3",drink3.count)
        outState.putFloat("bill",bill)

        Log.d(TAG,"onSaveInstanceState called")

        }



    }




