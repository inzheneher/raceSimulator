package com.mav;

/**
 * Instance of this class is being notified when the next time quantum is over.
 */

interface RaceListener {
    void nextTimeQuantumPassed();
}