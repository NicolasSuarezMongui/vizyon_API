package com.campuslands.vizyon.services;

import java.util.Date;
import java.util.List;

import com.campuslands.vizyon.dtos.VentaDTO;

public interface ServiceVenta {

    List<VentaDTO> getVentas();

    List<VentaDTO> getVentasByMonthAndYear(int month, int year);

    List<VentaDTO> getVentasByDateRange(Date startDate, Date endDate);
}
