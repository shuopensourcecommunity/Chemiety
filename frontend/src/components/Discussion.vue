<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.layout-padding
    q-data-table(:data="topics",
                  :config="conf",
                  :columns="cols",
                  @refresh="refresh")


</template>

<script>
import {
  QDataTable
} from 'quasar'
export default {
  name: 'discussion',
  components: {
    QDataTable
  },
  data () {
    return {
      topics: [],
      conf: {},
      cols: []
    }
  }
}
this.conf = {
  // [REQUIRED] Set the row height
  rowHeight: '50px',
  // (optional) Title to display
  title: 'Data Table',
  // (optional) No columns header
  noHeader: true,
  // (optional) Display refresh button
  refresh: true,
  // (optional)
  // User will be able to choose which columns
  // should be displayed
  columnPicker: false,
  // (optional) How many columns from the left are sticky
  leftStickyColumns: 0,
  // (optional) How many columns from the right are sticky
  rightStickyColumns: 2,
  // (optional)
  // Styling the body of the data table;
  // "minHeight", "maxHeight" or "height" are important
  bodyStyle: {
    maxHeight: '500px'
  },
  // (optional) By default, Data Table is responsive,
  // but you can disable this by setting the property to "false"
  responsive: true,
  // (optional) Use pagination. Set how many rows per page
  // and also specify an additional optional parameter ("options")
  // which forces user to make a selection of how many rows per
  // page he wants from a specific list
  pagination: {
    rowsPerPage: 15,
    options: [5, 10, 15, 30, 50, 500]
  },
  // (optional) Select one or more rows for an action
  // "single" adds a column with radio buttons for single row selection
  // "multiple" adds a column with checkboxes for multiple row selection
  // omitting the property will result in no selection column at all
  selection: '',
  // (optional) Override default messages when no data is available
  // or the user filtering returned no results.
  messages: {
    noData: '<i>warning</i> No data available to show.',
    noDataAfterFiltering: '<i>warning</i> No results. Please refine your search terms.'
  },
  // (optional) Override default labels. Useful for I18n.
  labels: {
    columns: 'Coluuuuumns',
    allCols: 'Eeeeeeeeevery Cols',
    rows: 'Rooows',
    selected: {
      singular: 'item selected.',
      plural: 'items selected.'
    },
    clear: 'clear',
    search: 'Search',
    all: 'All'
  }
}
this.cols = [
  {
    // [REQUIRED] Column name
    label: '日期',
    // [REQUIRED] Row property name
    field: 'date',
    // [REQUIRED] Column width
    width: '100px',
    // (optional) Column CSS style
    style: {color: '#ff09fa'},
    // "style" can be a function too if you want to apply
    // certain CSS style based on cell value:
    // style (cell_value) { return .... }
    // (optional) Column CSS classes
    classes: 'bg-primary',
    // "classes" can be a function too if you want to apply
    // certain CSS class based on cell value:
    // classes (cell_value) { return .... }
    // (optional) Can filter/search be applied to this column?
    filter: true,
    // (optional) Sortable column?
    // If yes, then also specify `type` prop to know how to sort
    sort: true,
    // or you can specify a custom sorting method;
    // works same as Array.prototype.sort().
    // Return codes:
    //   < 0 --> "a" should be before "b"
    //   0   --> "a" is same as "b"
    //   > 0 --> "a" should be after "b"
    // sort (a, b) {
    //   return (new Date(a)) - (new Date(b))
    // },
    // Type required if using sort.
    // Available values: "string", "number", "date", "boolean"
    type: 'string',
    // (optional)
    // use a formatter for this column;
    // transforms original String in another String
    format (value, row) {
      return new Date(value).toLocaleString()
    }
  },
  {
    // [REQUIRED] Column name
    label: '主题',
    // [REQUIRED] Row property name
    field: 'topic',
    // [REQUIRED] Column width
    width: '100px',
    // (optional) Column CSS style
    style: {color: '#ff09fa'},
    // "style" can be a function too if you want to apply
    // certain CSS style based on cell value:
    // style (cell_value) { return .... }
    // (optional) Column CSS classes
    classes: 'bg-primary',
    // "classes" can be a function too if you want to apply
    // certain CSS class based on cell value:
    // classes (cell_value) { return .... }
    // (optional) Can filter/search be applied to this column?
    filter: true,
    // (optional) Sortable column?
    // If yes, then also specify `type` prop to know how to sort
    sort: true,
    // or you can specify a custom sorting method;
    // works same as Array.prototype.sort().
    // Return codes:
    //   < 0 --> "a" should be before "b"
    //   0   --> "a" is same as "b"
    //   > 0 --> "a" should be after "b"
    // sort (a, b) {
    //   return (new Date(a)) - (new Date(b))
    // },
    // Type required if using sort.
    // Available values: "string", "number", "date", "boolean"
    type: 'string',
    // (optional)
    // use a formatter for this column;
    // transforms original String in another String
    format (value, row) {
      return new Date(value).toLocaleString()
    }
  }
]
</script>

<style lang="stylus">
.layout-padding
  padding 50
</style>
