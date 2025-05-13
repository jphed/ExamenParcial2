package com.example.mobile1project.Parcial3.repository

import LocationApiService
import com.example.mobile1project.Parcial3.model.Location


class LocationRepository(private val apiService: LocationApiService) {
    suspend fun fetchLocations(): List<Location> {
        return apiService.getLocations()
    }
}
