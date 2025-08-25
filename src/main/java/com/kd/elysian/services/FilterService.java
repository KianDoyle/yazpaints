package com.kd.elysian.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kd.elysian.models.Filter;
import com.kd.elysian.repositories.FilterRepository;

@Service
public class FilterService {
    
    private final FilterRepository filterRepository;

    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public List<Filter> getAllFilters() {
        return filterRepository.findAll();
    }

    public Filter getFilterById(Integer id) {
        return filterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Filter with ID " + id + " does not exist."));
    }

    public Filter addFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    public Filter deleteFilter(Integer id) {
        Filter filter = filterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Filter with ID " + id + " does not exist."));
        filterRepository.delete(filter);
        return filter;
    }
}
