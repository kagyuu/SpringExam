import React, { useState, useEffect } from "react";

export const PieceFetch = () => {
	const [pieces, setPiece] = useState([]);

	useEffect(() => {
		fetch("/api/findByNumber?number=1", { method: "GET" })
			.then((res) => res.json())
			.then((data) => {
				setPiece(data);
			});
	}, []);

	return (
		<div>
			<ul>
				<li>{pieces.number}</li>
				<li>{pieces.name}</li>
				<li>{pieces.color}</li>
				<li>{pieces.shape}</li>
			</ul>
		</div>
	);
};