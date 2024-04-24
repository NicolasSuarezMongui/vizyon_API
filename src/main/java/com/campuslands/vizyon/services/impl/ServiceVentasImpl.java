package com.campuslands.vizyon.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campuslands.vizyon.config.VentaDTOConverter;
import com.campuslands.vizyon.dtos.VentaDTO;
import com.campuslands.vizyon.repositories.RepositoryVenta;
import com.campuslands.vizyon.repositories.entities.Venta;
import com.campuslands.vizyon.services.ServiceVenta;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

@Service
@AllArgsConstructor
public class ServiceVentasImpl implements ServiceVenta{
    
    @Autowired
    private RepositoryVenta repositoryVentas;

    private VentaDTOConverter converter;

    @Override
    public List<VentaDTO> getVentas() {
        List<Venta> ventas = (List<Venta>) repositoryVentas.findAll();
        return ventas.stream()
                .map(venta -> converter.convertToDTO(venta))
                .toList();
    }
    @Override
    public List<VentaDTO> getVentasByMonthAndYear(int month, int year) {
        List<Venta> ventas = (List<Venta>) repositoryVentas.findAll();
        return ventas.stream()
                .filter(venta -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(venta.getFecha());
                    return calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) == year;
                })
                .map(venta -> converter.convertToDTO(venta))
                .toList();
    }

    @Override
    public List<VentaDTO> getVentasByDateRange(Date startDate, Date endDate) {
        List<Venta> ventas = (List<Venta>) repositoryVentas.findAll();
        return ventas.stream()
                .filter(venta -> {
                    Date saleDate = venta.getFecha();
                    return saleDate.after(startDate) && saleDate.before(endDate);
                })
                .map(venta -> converter.convertToDTO(venta))
                .toList();
    }

}
