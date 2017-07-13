//
//  grid.cpp
//  ai.core
//
//  Created by Viktor Kuznietsov on 7/5/17.
//  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
//

#include "grid.hpp"

namespace eight_puzzle {
    
    std::vector<std::vector<int>> grid::_final_state {
        {grid::EMPTY_VALUE, 1, 2},
        {3, 4, 5},
        {6, 7, 8}
    };
    
    grid::grid(const std::vector<std::vector<int>>& state) {
        _state.resize(GRID_SIZE);

        _empty_cell = std::unique_ptr<point>(new point());
        
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                _state[i].push_back(state[i][j]);

                if (EMPTY_VALUE == state[i][j]) {
                    _empty_cell->first = i;
                    _empty_cell->second = j;
                }
            }
        }
    }
    
    bool grid::is_final_state() const {
        return match_with_final_state();
    }
    
    std::ostream& operator<<(std::ostream& os, const eight_puzzle::grid& g) {
        for (int i = 0; i < grid::GRID_SIZE; ++i) {
            for (int j = 0; j < grid::GRID_SIZE; ++j) {
                os << g._state[i][j] << " ";
            }
            
            os << std::endl;
        }
        
        return os;
    }
    
    bool grid::match_with_final_state() const {
        if (_state[0][0] != grid::EMPTY_VALUE)
            return false;
        
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                if (_final_state[i][j] != _state[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    std::vector<std::vector<int>> grid::get_state(const directions &direction) const {
        // TODO
        return std::vector<std::vector<int>>();
    }

    std::vector<directions> grid::get_directions() const {
        std::vector<directions> result;

        if (_empty_cell->first > 0) {
            result.push_back(LEFT);
        }

        if (_empty_cell->first < GRID_SIZE - 1) {
            result.push_back(RIGHT);
        }

        if (_empty_cell->second > 0) {
            result.push_back(UP);
        }

        if (_empty_cell->second < GRID_SIZE - 1) {
            result.push_back(DOWN);
        }

        return result;
    }

}
