import React, { Component } from 'react';
import axios from 'axios';
import Book from './Book';

class BookList extends Component {
    constructor(props) {
        super(props);
        this.state = {books:[]};
    }

    componentDidMount() {
        axios.get('http://localhost:8080/api/books')
        .then(response=>{this.setState({books:response.data})})
    }

    render() {
        const bookList = this.state.books.map(book=>{
            return <Book key = {book.id} book = {book}/>
        })

        return<table>
            <thead>
                <tr>
                <th> Book </th>
                </tr>
            </thead>
            <tbody>
            {bookList}
            </tbody> 
        </table>
    }
}
export default BookList;